package com.malibin.acnh.wiki.data.repository

import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource
import kotlin.collections.LinkedHashMap

/**
 * Created By Yun Hyeok
 * on 5월 25, 2020
 */

class VillagersRepository(
    private val villagersLocalDataSource: VillagersDataSource,
    private val villagersRemoteDataSource: VillagersDataSource
) : VillagersDataSource {

    private val cachedVillagers = LinkedHashMap<Int, Villager>()
    private var isFullLoaded = false

    override suspend fun getAllVillagers(): List<Villager> {
        if (cachedVillagers.isNotEmpty() && isFullLoaded) {
            return cachedVillagers.values.toList().sortedBy { it.amiiboIndex }
        }
        val localVillagers = villagersLocalDataSource.getAllVillagers()
        isFullLoaded = true
        if (localVillagers.isEmpty()) {
            return loadVillagersFromRemoteAndGet()
        }
        cacheVillagers(localVillagers)
        return localVillagers
    }

    private suspend fun loadVillagersFromRemoteAndGet(): List<Villager> {
        val remoteVillagers = villagersRemoteDataSource.getAllVillagers()
        cacheVillagers(remoteVillagers)
        villagersLocalDataSource.saveVillagers(remoteVillagers)
        return remoteVillagers
    }

    private fun cacheVillagers(villagers: List<Villager>) {
        villagers
            .map { it.copy() }
            .forEach { cachedVillagers[it.amiiboIndex] = it }
    }

    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        return getCachedVillagerById(amiiboIndex)
            ?: villagersLocalDataSource.fetchVillager(amiiboIndex)
    }

    override suspend fun getVillagersInHome(): List<Villager> {
        if (cachedVillagers.isEmpty()) {
            val villagersInHome = villagersLocalDataSource.getVillagersInHome()
            cacheVillagers(villagersInHome)
            return villagersInHome
        }
        return cachedVillagers.values
            .filter { it.isInHome }
            .sortedBy { it.amiiboIndex }
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        if (cachedVillagers.isEmpty()) {
            val favoriteVillagers = villagersLocalDataSource.getFavoriteVillagers()
            cacheVillagers(favoriteVillagers)
            return favoriteVillagers
        }
        return cachedVillagers.values
            .filter { it.isFavorite }
            .sortedBy { it.amiiboIndex }
    }

    override suspend fun saveVillagers(villagers: List<Villager>) {
        // Not Available
    }

    override suspend fun deleteAllVillagers() {
        cachedVillagers.clear()
        villagersLocalDataSource.deleteAllVillagers()
    }

    override suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean) {
        getCachedVillagerById(villager.amiiboIndex)?.let {
            it.isFavorite = isChecked
            villagersLocalDataSource.checkFavoriteVillager(it, isChecked)
        }
    }

    override suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean) {
        getCachedVillagerById(villager.amiiboIndex)?.let {
            it.isInHome = isChecked
            villagersLocalDataSource.checkHomeVillager(it, isChecked)
        }
    }

    private fun getCachedVillagerById(amiiboIndex: Int) = cachedVillagers[amiiboIndex]

}

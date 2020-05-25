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

    override suspend fun getAllVillagers(): List<Villager> {
        if (cachedVillagers.isNotEmpty()) {
            return cachedVillagers.values.toList()
        }
        val localVillagers = villagersLocalDataSource.getAllVillagers()
        if (localVillagers.isEmpty()) {
            return loadVillagersFromRemoteAndGet()
        }
        refreshCache(localVillagers)
        return localVillagers
    }

    private suspend fun loadVillagersFromRemoteAndGet(): List<Villager> {
        val remoteVillagers = villagersRemoteDataSource.getAllVillagers()
        refreshCache(remoteVillagers)
        villagersLocalDataSource.saveVillagers(remoteVillagers)
        return remoteVillagers
    }

    private fun refreshCache(villagers: List<Villager>) {
        cachedVillagers.clear()
        villagers
            .map { it.copy() }
            .forEach { cachedVillagers[it.amiiboIndex] = it }
    }

    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        return getCachedVillagerById(amiiboIndex)
            ?: villagersLocalDataSource.fetchVillager(amiiboIndex)
    }

    private fun getCachedVillagerById(amiiboIndex: Int) = cachedVillagers[amiiboIndex]

    override suspend fun saveVillagers(villagers: List<Villager>) {
        // Not Available
    }

    override suspend fun deleteAllVillagers() {
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

}

package com.malibin.acnh.wiki.data.repository

import android.util.Log
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource

/**
 * Created By Yun Hyeok
 * on 5월 25, 2020
 */

class VillagersRepository(
    private val villagersLocalDataSource: VillagersDataSource,
    private val villagersRemoteDataSource: VillagersDataSource
) : VillagersDataSource {

    private var isFullLoaded = false
    private var isInHomeLoaded = false
    private var isFavoritesLoaded = false
    private val cachedVillagers = HashMap<Int, Villager>()

    @Synchronized
    override suspend fun getAllVillagers(): List<Villager> {
        if (cachedVillagers.isNotEmpty() && isFullLoaded) {
            Log.d("Malibin Debug", "getAllVillagers Loaded from cache")
            return cachedVillagers.values.toList().sortedBy { it.amiiboIndex }
        }
        isFullLoaded = true
        val localVillagers = villagersLocalDataSource.getAllVillagers()
        if (localVillagers.isEmpty()) {
            val remoteVillagers = villagersRemoteDataSource.getAllVillagers()
            cacheVillagers(remoteVillagers)
            villagersLocalDataSource.saveVillagers(remoteVillagers)
            return remoteVillagers
        }
        cacheVillagers(localVillagers)
        return localVillagers
    }

    private fun cacheVillagers(villagers: List<Villager>) {
        villagers
            .map { it.copy() }
            .forEach { cachedVillagers[it.amiiboIndex] = it }
    }

    @Synchronized
    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        return getCachedVillagerById(amiiboIndex)
    }

    override suspend fun getVillagersInHome(): List<Villager> {
        if (!isInHomeLoaded && !isFullLoaded) {
            val villagersInHome = villagersLocalDataSource.getVillagersInHome()
            cacheVillagers(villagersInHome)
            isInHomeLoaded = true
            return villagersInHome
        }
        return cachedVillagers.values
            .filter { it.isInHome }
            .sortedBy { it.amiiboIndex }
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        if (!isFavoritesLoaded && !isFullLoaded) {
            val favoriteVillagers = villagersLocalDataSource.getFavoriteVillagers()
            cacheVillagers(favoriteVillagers)
            isFavoritesLoaded = true
            return favoriteVillagers
        }
        return cachedVillagers.values
            .filter { it.isFavorite }
            .sortedBy { it.amiiboIndex }
    }

    override suspend fun saveVillagers(villagers: List<Villager>) {
        throw UnsupportedOperationException("cannot call saveVillagers in repository")
    }

    override suspend fun deleteAllVillagers() {
        cachedVillagers.clear()
        villagersLocalDataSource.deleteAllVillagers()
    }

    override suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean) {
        val cachedVillager = getCachedVillagerById(villager.amiiboIndex)
        val newCopy = cachedVillager.copy(isFavorite = isChecked)
        cachedVillagers[villager.amiiboIndex] = newCopy
        villagersLocalDataSource.checkFavoriteVillager(villager, isChecked)
    }

    override suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean) {
        val cachedVillager = getCachedVillagerById(villager.amiiboIndex)
        val newCopy = cachedVillager.copy(isInHome = isChecked)
        cachedVillagers[villager.amiiboIndex] = newCopy
        villagersLocalDataSource.checkHomeVillager(villager, isChecked)
    }

    private fun getCachedVillagerById(amiiboIndex: Int): Villager {
        Log.d("Malibin Debug", "fetchVillager Loaded from cache")
        return cachedVillagers[amiiboIndex]
            ?: throw IllegalStateException("cached villager cannot be null")
    }

}

package com.malibin.acnh.wiki.data.source.local

import com.malibin.acnh.wiki.data.dao.VillagersDao
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource

class VillagersLocalDataSource(
    private val villagersDao: VillagersDao
) : VillagersDataSource {
    override suspend fun getAllVillagers(): List<Villager> {
        return villagersDao.getAllVillagers()
    }

    override suspend fun getVillagerById(amiiboIndex: Int): Villager? {
        return villagersDao.getVillagerById(amiiboIndex)
    }

    override suspend fun getVillagerInHome(): List<Villager> {
        return villagersDao.getVillagersInHome()
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        return villagersDao.getFavoriteVillagers()
    }

    override suspend fun deleteAllVillagers() {
        villagersDao.deleteAllVillagers()
    }

    override suspend fun checkFavoriteVillager(villager: Villager) {
        villagersDao.updateIsFavorite(villager.amiiboIndex, true)
    }

    override suspend fun unCheckFavoriteVillager(villager: Villager) {
        villagersDao.updateIsFavorite(villager.amiiboIndex, false)
    }

    override suspend fun checkHomeVillager(villager: Villager) {
        villagersDao.updateIsInHome(villager.amiiboIndex, true)
    }

    override suspend fun unCheckHomeVillager(villager: Villager) {
        villagersDao.updateIsInHome(villager.amiiboIndex, false)
    }
}
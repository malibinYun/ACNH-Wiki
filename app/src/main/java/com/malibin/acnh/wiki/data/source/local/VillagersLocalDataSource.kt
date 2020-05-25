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

    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        return villagersDao.getVillagerById(amiiboIndex)
    }

    override suspend fun saveVillagers(villagers: List<Villager>) {
        villagersDao.insertVillagers(villagers)
    }

    override suspend fun deleteAllVillagers() {
        villagersDao.deleteAllVillagers()
    }

    override suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean) {
        villagersDao.updateIsFavorite(villager.amiiboIndex, isChecked)
    }

    override suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean) {
        villagersDao.updateIsInHome(villager.amiiboIndex, isChecked)
    }

}
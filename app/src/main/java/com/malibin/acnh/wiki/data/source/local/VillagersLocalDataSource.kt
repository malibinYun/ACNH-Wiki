package com.malibin.acnh.wiki.data.source.local

import android.util.Log
import com.malibin.acnh.wiki.data.dao.VillagersDao
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource

class VillagersLocalDataSource(
    private val villagersDao: VillagersDao
) : VillagersDataSource {

    override suspend fun getAllVillagers(): List<Villager> {
        Log.d("Malibin Debug", "getAllVillagers Loaded from local")
        return villagersDao.getAllVillagers()
    }

    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        Log.d("Malibin Debug", "fetchVillager Loaded from local")
        return villagersDao.getVillagerById(amiiboIndex)
    }

    override suspend fun getVillagersInHome(): List<Villager> {
        return villagersDao.getVillagersInHome()
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        return villagersDao.getFavoriteVillagers()
    }

    override suspend fun saveVillagers(villagers: List<Villager>) {
        Log.d("Malibin Debug", "VillagersSaved")
        villagersDao.insertVillagers(villagers)
    }

    override suspend fun deleteAllVillagers() {
        villagersDao.deleteAllVillagers()
    }

    override suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean) {
        Log.d("Malibin Debug", "${villager.nameKor} is Favorite $isChecked")
        villagersDao.updateIsFavorite(villager.amiiboIndex, isChecked)
    }

    override suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean) {
        Log.d("Malibin Debug", "${villager.nameKor} is in Home $isChecked")
        villagersDao.updateIsInHome(villager.amiiboIndex, isChecked)
    }

}
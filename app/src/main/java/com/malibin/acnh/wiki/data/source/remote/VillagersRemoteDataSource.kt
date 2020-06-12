package com.malibin.acnh.wiki.data.source.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource
import com.malibin.acnh.wiki.data.util.VILLAGERS_PATH
import com.malibin.acnh.wiki.data.util.getCollectionSnapshot
import com.malibin.acnh.wiki.data.util.toVillagers
import kotlinx.coroutines.tasks.await

/**
 * Created By Yun Hyeok
 * on 5월 25, 2020
 */

class VillagersRemoteDataSource(
    private val fireStore: FirebaseFirestore
) : VillagersDataSource {

    override suspend fun getAllVillagers(): List<Villager> {
        val snapshot = fireStore.getCollectionSnapshot(VILLAGERS_PATH).await()
        return snapshot.toVillagers()
    }

    override suspend fun fetchVillager(amiiboIndex: Int): Villager? {
        throw UnsupportedOperationException("Cannot call fetchVillager in remote source")
    }

    override suspend fun getVillagersInHome(): List<Villager> {
        throw UnsupportedOperationException("Cannot call getVillagersInHome in remote source")
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        throw UnsupportedOperationException("Cannot call getFavoriteVillagers in remote source")
    }

    override suspend fun saveVillagers(villagers: List<Villager>) {
        throw UnsupportedOperationException("Cannot call saveVillagers in remote source")
    }

    override suspend fun deleteAllVillagers() {
        throw UnsupportedOperationException("Cannot call deleteAllVillagers in remote source")
    }

    override suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkFavoriteVillager in remote source")
    }

    override suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkHomeVillager in remote source")
    }

}
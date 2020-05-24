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

    override suspend fun getVillagerById(amiiboIndex: Int): Villager? {
        // Cannot Write Remote Source
        return null
    }

    override suspend fun getVillagerInHome(): List<Villager> {
        // Cannot Write Remote Source
        return emptyList()
    }

    override suspend fun getFavoriteVillagers(): List<Villager> {
        // Cannot Write Remote Source
        return emptyList()
    }

    override suspend fun deleteAllVillagers() {
        // Cannot Write Remote Source
    }

    override suspend fun checkFavoriteVillager(villager: Villager) {
        // Cannot Write Remote Source
    }

    override suspend fun unCheckFavoriteVillager(villager: Villager) {
        // Cannot Write Remote Source
    }

    override suspend fun checkHomeVillager(villager: Villager) {
        // Cannot Write Remote Source
    }

    override suspend fun unCheckHomeVillager(villager: Villager) {
        // Cannot Write Remote Source
    }
}
package com.malibin.acnh.wiki.data.source.remote

import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.source.VillagersDataSource
import com.malibin.acnh.wiki.data.textparser.VillagerTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Yun Hyeok
 * on 5월 25, 2020
 */

class VillagersRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : VillagersDataSource {

    override suspend fun getAllVillagers(): List<Villager> {
        Log.d("Malibin Debug", "getAllVillagers Loaded from remote")
        val rawText = firebaseStorage.getRawItemTextOf("villager/villagers")
        return VillagerTextParser.convert(rawText)
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
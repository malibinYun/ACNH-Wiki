package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.entity.Villager

interface VillagersDataSource {

    suspend fun getAllVillagers(): List<Villager>

    suspend fun fetchVillager(amiiboIndex: Int): Villager?

    suspend fun saveVillagers(villagers: List<Villager>)

    suspend fun deleteAllVillagers()

    suspend fun checkFavoriteVillager(villager: Villager, isChecked: Boolean)

    suspend fun checkHomeVillager(villager: Villager, isChecked: Boolean)

}
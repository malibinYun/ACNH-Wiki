package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.entity.Villager

interface VillagersDataSource {

    suspend fun getAllVillagers(): List<Villager>

    suspend fun getVillagerById(amiiboIndex: Int): Villager?

    suspend fun getVillagerInHome(): List<Villager>

    suspend fun getFavoriteVillagers(): List<Villager>

    suspend fun deleteAllVillagers()

    suspend fun checkFavoriteVillager(villager: Villager)

    suspend fun unCheckFavoriteVillager(villager: Villager)

    suspend fun checkHomeVillager(villager: Villager)

    suspend fun unCheckHomeVillager(villager: Villager)

}
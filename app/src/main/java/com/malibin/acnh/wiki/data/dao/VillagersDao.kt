package com.malibin.acnh.wiki.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.malibin.acnh.wiki.data.entity.Villager

/**
 * Created By Yun Hyeok
 * on 5월 22, 2020
 */

@Dao
interface VillagersDao {

    @Query("SELECT * FROM villager")
    suspend fun getAllVillagers(): List<Villager>

    @Query("SELECT * FROM villager WHERE amiiboIndex = :amiiboIndex")
    suspend fun getVillagerById(amiiboIndex: Int): Villager?

    @Query("SELECT * FROM villager WHERE isInHome = 1")
    suspend fun getVillagersInHome(): List<Villager>

    @Query("SELECT * FROM villager WHERE isFavorite = 1")
    suspend fun getFavoriteVillagers(): List<Villager>

    @Insert
    suspend fun insertVillagers(villagers: List<Villager>)

    @Query("UPDATE villager SET isInHome = :isInHome WHERE amiiboIndex = :amiiboIndex")
    suspend fun updateIsInHome(amiiboIndex: Int, isInHome: Boolean)

    @Query("UPDATE villager SET isInHome = :isFavorite WHERE amiiboIndex = :amiiboIndex")
    suspend fun updateIsFavorite(amiiboIndex: Int, isFavorite: Boolean)

    @Query("DELETE FROM villager")
    suspend fun deleteAllVillagers()

}
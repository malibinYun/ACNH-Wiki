package com.malibin.acnh.wiki.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.HouseInterior

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

@Dao
interface HouseInteriorsDao {

    @Query("SELECT itemType FROM houseinterior GROUP BY itemType")
    suspend fun getItemTypes(): List<ItemType>

    @Query("SELECT * FROM houseinterior")
    suspend fun getAllHouseInteriors(): List<HouseInterior>

    @Query("SELECT * FROM houseinterior WHERE id = :id")
    suspend fun findHouseInteriorById(id: Int): HouseInterior?

    @Query("SELECT * FROM houseinterior WHERE nameKor = :itemName")
    suspend fun findHouseInteriorByName(itemName: String): HouseInterior?

    @Query("SELECT * FROM houseinterior WHERE itemType = :itemType")
    suspend fun getHouseInteriorsOf(itemType: ItemType): List<HouseInterior>

    @Query("SELECT * FROM houseinterior WHERE collected = 1")
    suspend fun getCollectedHouseInteriors(): List<HouseInterior>

    @Query("SELECT * FROM houseinterior WHERE collected = 1 AND itemType = :itemType")
    suspend fun getCollectedHouseInteriorsOf(itemType: ItemType): List<HouseInterior>

    @Query("SELECT * FROM houseinterior WHERE wished = 1")
    suspend fun getWishedHouseInteriors(): List<HouseInterior>

    @Query("SELECT * FROM houseinterior WHERE wished = 1 AND itemType = :itemType")
    suspend fun getWishedHouseInteriorsOf(itemType: ItemType): List<HouseInterior>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHouseInteriors(items: List<HouseInterior>)

    @Query("DELETE FROM houseinterior")
    suspend fun deleteAllHouseInteriors()

    @Query("UPDATE houseinterior SET collected = :isChecked WHERE id = :itemId")
    suspend fun updateHouseInteriorCollected(itemId: Int, isChecked: Boolean)

    @Query("UPDATE houseinterior SET wished = :isChecked WHERE id = :itemId")
    suspend fun updateHouseInteriorWished(itemId: Int, isChecked: Boolean)

}
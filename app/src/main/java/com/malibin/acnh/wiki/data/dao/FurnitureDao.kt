package com.malibin.acnh.wiki.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Furniture

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

@Dao
interface FurnitureDao {

    @Query("SELECT itemType FROM furniture GROUP BY itemType")
    suspend fun getItemTypes(): List<ItemType>

    @Query("SELECT * FROM furniture")
    suspend fun getAllFurniture(): List<Furniture>

    @Query("SELECT * FROM furniture WHERE itemType = :itemType")
    suspend fun getFurnitureListOf(itemType: ItemType): List<Furniture>

    @Query("SELECT * FROM furniture WHERE id IN (:specificIds)")
    suspend fun getFurnitureListOf(specificIds: List<Int>): List<Furniture>

    @Query("SELECT * FROM furniture WHERE collected = 1")
    suspend fun getCollectedFurnitureList(): List<Furniture>

    @Query("SELECT * FROM furniture WHERE collected = 1 AND itemType = :itemType")
    suspend fun getCollectedFurnitureListOf(itemType: ItemType): List<Furniture>

    @Query("SELECT * FROM furniture WHERE wished = 1")
    suspend fun getWishedFurnitureList(): List<Furniture>

    @Query("SELECT * FROM furniture WHERE wished = 1 AND itemType = :itemType")
    suspend fun getWishedFurnitureListOf(itemType: ItemType): List<Furniture>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFurniture(items: List<Furniture>)

    @Query("DELETE FROM furniture")
    suspend fun deleteAllFurniture()

    @Query("UPDATE furniture SET collected = :isChecked WHERE id = :itemId")
    suspend fun updateFurnitureCollected(itemId: Int, isChecked: Boolean)

    @Query("UPDATE furniture SET wished = :isChecked WHERE id = :itemId")
    suspend fun updateFurnitureWished(itemId: Int, isChecked: Boolean)
}
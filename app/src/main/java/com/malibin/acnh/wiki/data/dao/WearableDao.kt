package com.malibin.acnh.wiki.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Wearable

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

interface WearableDao {

    @Query("SELECT itemType FROM wearable GROUP BY itemType")
    suspend fun getItemTypes(): List<ItemType>

    @Query("SELECT * FROM wearable GROUP BY nameKor")
    suspend fun getAllWearables(): List<Wearable>

    @Query("SELECT * FROM wearable WHERE itemType = :itemType GROUP BY nameKor")
    suspend fun getWearablesOf(itemType: ItemType): List<Wearable>

    @Query("SELECT * FROM wearable WHERE nameKor = :itemName")
    suspend fun getWearablesOf(itemName: String): List<Wearable>

    @Query("SELECT * FROM wearable WHERE collected = 1")
    suspend fun getCollectedWearables(): List<Wearable>

    @Query("SELECT * FROM wearable WHERE collected = 1 AND itemType = :itemType")
    suspend fun getCollectedWearablesOf(itemType: ItemType): List<Wearable>

    @Query("SELECT * FROM wearable WHERE wished = 1")
    suspend fun getWishedWearables(): List<Wearable>

    @Query("SELECT * FROM wearable WHERE wished = 1 AND itemType = :itemType")
    suspend fun getWishedWearablesOf(itemType: ItemType): List<Wearable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWearables(items: List<Wearable>)

    @Query("DELETE FROM wearable")
    suspend fun deleteAllWearables()

    @Query("UPDATE wearable SET collected = :isChecked WHERE id = :itemId")
    suspend fun updateWearableCollected(itemId: Int, isChecked: Boolean)

    @Query("UPDATE wearable SET wished = :isChecked WHERE id = :itemId")
    suspend fun updateWearableWished(itemId: Int, isChecked: Boolean)

}
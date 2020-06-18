package com.malibin.acnh.wiki.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.malibin.acnh.wiki.data.entity.Music

/**
 * Created By Malibin
 * on 6월 19, 2020
 */

interface MusicDao {

    @Query("SELECT * FROM music")
    suspend fun getAllMusics(): List<Music>

    @Query("SELECT * FROM music WHERE id = :id")
    suspend fun findMusicById(id: Int): Music?

    @Query("SELECT * FROM music WHERE collected = 1")
    suspend fun getCollectedMusics(): List<Music>

    @Query("SELECT * FROM music WHERE wished = 1")
    suspend fun getWishedMusics(): List<Music>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusics(items: List<Music>)

    @Query("DELETE FROM music")
    suspend fun deleteAllMusics()

    @Query("UPDATE music SET collected = :isChecked WHERE id = :itemId")
    suspend fun updateMusicCollected(itemId: Int, isChecked: Boolean)

    @Query("UPDATE music SET wished = :isChecked WHERE id = :itemId")
    suspend fun updateMusicWished(itemId: Int, isChecked: Boolean)

}
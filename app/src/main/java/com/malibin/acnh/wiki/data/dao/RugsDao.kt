package com.malibin.acnh.wiki.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.malibin.acnh.wiki.data.entity.catalog.Rug

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

@Dao
interface RugsDao {

    @Query("SELECT * FROM rug")
    suspend fun getAllRugs(): List<Rug>

    @Insert
    suspend fun insertRugs(rugs: List<Rug>)

    @Query("DELETE FROM rug")
    suspend fun deleteAllRugs()

}
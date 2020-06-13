package com.malibin.acnh.wiki.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.malibin.acnh.wiki.data.Catalog
import com.malibin.acnh.wiki.data.Top

@Dao
interface TopsDao {

    @Query("SELECT * FROM top")
    fun getTops(): LiveData<List<Top>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTop(top: Top)

    @Query("DELETE FROM top")
    fun deleteTops()

}
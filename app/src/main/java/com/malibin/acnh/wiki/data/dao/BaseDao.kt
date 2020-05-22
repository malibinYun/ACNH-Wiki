package com.malibin.acnh.wiki.data.dao

import androidx.room.Delete
import androidx.room.Insert

/**
 * Created By Yun Hyeok
 * on 5월 22, 2020
 */

interface BaseDao<T> {

    @Insert
    suspend fun insertAll(items: List<T>)

    @Delete
    suspend fun deleteAll(items: List<T>)

}
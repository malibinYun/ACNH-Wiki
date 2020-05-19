package com.malibin.acnh.wiki.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.malibin.acnh.wiki.data.dao.TopsDao

@Database(
    entities = [Top::class, Catalog::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun topsDao(): TopsDao

}
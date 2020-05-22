package com.malibin.acnh.wiki.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.malibin.acnh.wiki.data.dao.TopsDao
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.util.DateTypeConverter

@TypeConverters(DateTypeConverter::class)
@Database(
    entities = [Villager::class, Top::class, Catalog::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun topsDao(): TopsDao

}
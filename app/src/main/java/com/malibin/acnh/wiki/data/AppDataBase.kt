package com.malibin.acnh.wiki.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.malibin.acnh.wiki.data.dao.VillagersDao
import com.malibin.acnh.wiki.data.entity.*
import com.malibin.acnh.wiki.data.util.DateTypeConverter
import com.malibin.acnh.wiki.data.util.ItemTypeConverter
import com.malibin.acnh.wiki.data.util.ListTypeConverter

@TypeConverters(DateTypeConverter::class, ListTypeConverter::class, ItemTypeConverter::class)
@Database(
    entities = [
        Villager::class,
        Wearable::class,
        Furniture::class,
        HouseFurniture::class,
        Fence::class,
        Music::class,
        Poster::class,
        Photo::class,
        Tool::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun villagersDao(): VillagersDao

}
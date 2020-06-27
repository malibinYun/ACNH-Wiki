package com.malibin.acnh.wiki.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.malibin.acnh.wiki.data.dao.*
import com.malibin.acnh.wiki.data.entity.*
import com.malibin.acnh.wiki.data.util.CustomTypeConverters

@TypeConverters(CustomTypeConverters::class)
@Database(
    entities = [
        Villager::class,
        Wearable::class,
        Furniture::class,
        HouseInterior::class,
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
    abstract fun furnitureDao(): FurnitureDao
    abstract fun houseInteriorsDao(): HouseInteriorsDao
    abstract fun wearablesDao(): WearableDao
    abstract fun musicDao(): MusicDao

}
package com.malibin.acnh.wiki.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.malibin.acnh.wiki.data.dao.RugsDao
import com.malibin.acnh.wiki.data.dao.TopsDao
import com.malibin.acnh.wiki.data.dao.VillagersDao
import com.malibin.acnh.wiki.data.entity.Rug
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.util.DateTypeConverter
import com.malibin.acnh.wiki.data.util.ItemTypeConverter
import com.malibin.acnh.wiki.data.util.ListTypeConverter

@TypeConverters(DateTypeConverter::class, ListTypeConverter::class, ItemTypeConverter::class)
@Database(
    entities = [Villager::class, Top::class, Catalog::class, Rug::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun topsDao(): TopsDao

    abstract fun villagersDao(): VillagersDao

    abstract fun rugsDao(): RugsDao

}
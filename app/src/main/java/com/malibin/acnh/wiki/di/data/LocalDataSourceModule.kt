package com.malibin.acnh.wiki.di.data

import androidx.room.Room
import com.malibin.acnh.wiki.data.AppDataBase
import com.malibin.acnh.wiki.data.source.local.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

val dataBaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDataBase::class.java,
            "ACNH_database"
        ).build()
    }
}

val localDataSourceModule = module {
    single { VillagersLocalDataSource(get<AppDataBase>().villagersDao()) }
    single { FurnitureLocalDataSource(get<AppDataBase>().furnitureDao()) }
    single { HouseInteriorLocalDataSource(get<AppDataBase>().houseInteriorsDao()) }
    single { WearablesLocalDataSource(get<AppDataBase>().wearablesDao()) }
    single { MusicLocalDataSource(get<AppDataBase>().musicDao()) }
}

val localModules = listOf(
    dataBaseModule,
    localDataSourceModule
)
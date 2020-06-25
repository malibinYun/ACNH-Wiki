package com.malibin.acnh.wiki.di.data

import com.malibin.acnh.wiki.data.repository.*
import com.malibin.acnh.wiki.data.source.local.*
import com.malibin.acnh.wiki.data.source.remote.*
import org.koin.dsl.module

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

val repositoryModule = module {
    single {
        VillagersRepository(
            get<VillagersLocalDataSource>(),
            get<VillagersRemoteDataSource>()
        )
    }
    single {
        FurnitureRepository(
            get<FurnitureLocalDataSource>(),
            get<FurnitureRemoteDataSource>()
        )
    }
    single {
        HouseInteriorsRepository(
            get<HouseInteriorLocalDataSource>(),
            get<HouseInteriorsRemoteDataSource>()
        )
    }
    single {
        WearablesRepository(
            get<WearablesLocalDataSource>(),
            get<WearablesRemoteDataSource>()
        )
    }
    single {
        MusicRepository(
            get<MusicLocalDataSource>(),
            get<MusicRemoteDataSource>()
        )
    }
}

val repositoryModules = listOf(
    repositoryModule
)
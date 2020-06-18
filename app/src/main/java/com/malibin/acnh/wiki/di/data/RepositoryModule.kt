package com.malibin.acnh.wiki.di.data

import com.malibin.acnh.wiki.data.repository.FurnitureRepository
import com.malibin.acnh.wiki.data.repository.MusicRepository
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.data.source.local.FurnitureLocalDataSource
import com.malibin.acnh.wiki.data.source.local.MusicLocalDataSource
import com.malibin.acnh.wiki.data.source.local.VillagersLocalDataSource
import com.malibin.acnh.wiki.data.source.remote.FurnitureRemoteDataSource
import com.malibin.acnh.wiki.data.source.remote.MusicRemoteDataSource
import com.malibin.acnh.wiki.data.source.remote.VillagersRemoteDataSource
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
        MusicRepository(
            get<MusicLocalDataSource>(),
            get<MusicRemoteDataSource>()
        )
    }
}

val repositoryModules = listOf(
    repositoryModule
)
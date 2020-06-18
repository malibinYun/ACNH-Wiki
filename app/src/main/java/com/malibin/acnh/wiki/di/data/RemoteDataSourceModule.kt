package com.malibin.acnh.wiki.di.data

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.source.remote.FurnitureRemoteDataSource
import com.malibin.acnh.wiki.data.source.remote.HouseInteriorsRemoteDataSource
import com.malibin.acnh.wiki.data.source.remote.VillagersRemoteDataSource
import com.malibin.acnh.wiki.data.source.remote.WearablesRemoteDataSource
import org.koin.dsl.module

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

val firebaseStorageModule = module {
    single { FirebaseStorage.getInstance() }
}

val remoteDataSourceModule = module {
    single { VillagersRemoteDataSource(get()) }
    single { FurnitureRemoteDataSource(get()) }
    single { HouseInteriorsRemoteDataSource(get()) }
    single { WearablesRemoteDataSource(get()) }
}

val remoteModules = listOf(
    firebaseStorageModule,
    remoteDataSourceModule
)


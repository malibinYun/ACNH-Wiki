package com.malibin.acnh.wiki.di

import com.malibin.acnh.wiki.ui.villager.VillagersViewModel
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

val viewModelModule = module {
    viewModel { VillagersViewModel(get()) }
    viewModel { VillagerDetailViewModel(get()) }
}

val viewModelModules = listOf(
    viewModelModule
)
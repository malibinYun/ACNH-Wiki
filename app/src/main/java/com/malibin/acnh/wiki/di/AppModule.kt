package com.malibin.acnh.wiki.di

import com.malibin.acnh.wiki.di.data.localModules
import com.malibin.acnh.wiki.di.data.remoteModules
import com.malibin.acnh.wiki.di.data.repositoryModules

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

val diModules = listOf(
    localModules,
    remoteModules,
    repositoryModules,
    viewModelModules
).flatten()
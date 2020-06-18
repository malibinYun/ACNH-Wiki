package com.malibin.acnh.wiki

import android.app.Application
import com.malibin.acnh.wiki.di.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class ACNHApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(diModules)
            androidContext(this@ACNHApplication)
        }
    }
}
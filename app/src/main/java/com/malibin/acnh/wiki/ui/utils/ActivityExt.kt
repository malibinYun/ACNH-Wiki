package com.malibin.acnh.wiki.ui.utils

import android.os.Build
import android.view.Window
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes containerId: Int) {
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commit()
}

fun AppCompatActivity.addFragmentToActivity(
    fragment: Fragment,
    @IdRes containerId: Int,
    tag: String? = null
) {
    supportFragmentManager.beginTransaction()
        .add(containerId, fragment, tag)
        .addToBackStack(fragment::class.simpleName)
        .commit()
}

fun AppCompatActivity.changeStatusBarColor(@ColorRes color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.window.statusBarColor = resources.getColor(color, null)
    } else {
        this.window.statusBarColor = resources.getColor(color)
    }
}

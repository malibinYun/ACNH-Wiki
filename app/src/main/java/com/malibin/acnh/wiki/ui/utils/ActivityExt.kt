package com.malibin.acnh.wiki.ui.utils

import androidx.annotation.IdRes
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

fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, tag: String) {
    supportFragmentManager.beginTransaction()
        .add(fragment, tag)
        .commit()
}
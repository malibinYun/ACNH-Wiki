package com.malibin.acnh.wiki.data

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

data class Item(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val colors: List<String>,
    val type: ItemType,
    val isCollected: Boolean,
    val isWished: Boolean
)
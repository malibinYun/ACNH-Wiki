package com.malibin.acnh.wiki.data.response

/**
 * Created By Malibin
 * on 5월 30, 2020
 */

data class FMusic(
    val nameKor: String,
    val id: Int,
    val nameEng: String,
    val imageUrl: String,
    val buyCost: Int?,
    val sellPrice: Int,
    val source: String,
    val sourceNote: String,
    val colors: List<String>,
    val available: String,
    val canDiy: Boolean,
    val size: String,
    val albumImageUrl: String
) {
    constructor() : this(
        nameKor = "",
        id = -1,
        nameEng = "",
        imageUrl = "",
        buyCost = null,
        sellPrice = 0,
        source = "",
        sourceNote = "",
        colors = emptyList(),
        available = "",
        canDiy = false,
        size = "",
        albumImageUrl = ""
    )
}
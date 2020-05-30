package com.malibin.acnh.wiki.data.response

/**
 * Created By Malibin
 * on 5월 30, 2020
 */

data class FShoes(
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
    val closetImageUrl: String,
    val seasonalAvailability: String,
    val style: String,
    val labelThemes: List<String>,
    val variation: String,
    val canVillagerWear: Boolean,
    val milesPrice: Int?
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
        closetImageUrl = "",
        seasonalAvailability = "",
        style = "",
        labelThemes = emptyList(),
        variation = "",
        canVillagerWear = false,
        milesPrice = null
    )
}

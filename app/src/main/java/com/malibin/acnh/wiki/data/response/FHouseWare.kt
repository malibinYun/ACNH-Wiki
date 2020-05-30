package com.malibin.acnh.wiki.data.response

/**
 * Created By Malibin
 * on 5월 30, 2020
 */

data class FHouseWare(
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
    val variantId: String?,
    val variation: String?,
    val bodyTitle: String?,
    val pattern: String?,
    val patternTitle: String?,
    val kitCost: Int?,
    val canBodyCustom: Boolean,
    val canPatternCustom: Boolean,
    val milesPrice: Int?,
    val canOutDoor: Boolean
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
        variantId = null,
        variation = null,
        bodyTitle = null,
        pattern = null,
        patternTitle = null,
        kitCost = null,
        canBodyCustom = false,
        canPatternCustom = false,
        milesPrice = null,
        canOutDoor = false
    )
}
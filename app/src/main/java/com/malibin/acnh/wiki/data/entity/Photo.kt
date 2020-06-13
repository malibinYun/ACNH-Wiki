package com.malibin.acnh.wiki.data.entity

/**
 * Created By Malibin
 * on 6월 13, 2020
 */

class Photo(
    id: Int,
    nameKor: String,
    nameEng: String,
    imageUrl: String,
    buyCost: Int?,
    sellPrice: Int,
    source: String,
    sourceNote: String,
    colors: List<String>,
    available: String,
    canDiy: Boolean,
    size: String,
    milesPrice: Int?,
    dType: Type,
    val variantId: String,
    val variationName: String,
    val bodyTitle: String,
    val patternName: String,
    val patternTitle: String,
    val kitCost: Int,
    val canBodyCustom: Boolean
) : Item(
    id = id,
    nameKor = nameKor,
    nameEng = nameEng,
    imageUrl = imageUrl,
    buyCost = buyCost,
    sellPrice = sellPrice,
    source = source,
    sourceNote = sourceNote,
    colors = colors,
    available = available,
    canDiy = canDiy,
    size = size,
    milesPrice = milesPrice,
    dType = dType
)
package com.malibin.acnh.wiki.data.response.catalog

import com.malibin.acnh.wiki.data.entity.catalog.Rug

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

data class FRug(
    val id: Int,
    val nameKor: String,
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
    val hhaConcepts: List<String>, // 삭제해라
    val hhaSeries: String, // 삭제해라
    val milesPrice: Int?
) {
    constructor() : this(
        id = -1,
        nameKor = "",
        nameEng = "",
        imageUrl = "",
        buyCost = -1,
        sellPrice = -1,
        source = "",
        sourceNote = "",
        colors = emptyList(),
        available = "",
        canDiy = false,
        size = "",
        hhaConcepts = emptyList(),
        hhaSeries = "",
        milesPrice = null
    )

    fun toRug() = Rug(
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
        hhaConcepts = hhaConcepts,
        hhaSeries = hhaSeries,
        milesPrice = milesPrice
    )
}

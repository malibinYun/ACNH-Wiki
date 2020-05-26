package com.malibin.acnh.wiki.data.response

import com.malibin.acnh.wiki.data.entity.Rug

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

data class FRug(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val buyCost: Int,
    val sellPrice: Int,
    val source: String,
    val sourceNote: String,
    val colors: List<String>,
    val available: String,
    val canDiy: Boolean,
    val size: String,
    val hhaConcepts: List<String>,
    val hhaSeries: String,
    val milesPrice: Int?
) {
    constructor() : this(
        id = -1,
        name = "",
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
        name = name,
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
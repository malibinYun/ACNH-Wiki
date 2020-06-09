package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import com.malibin.acnh.wiki.data.entity.Item

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

@Entity
class Rug(
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
    milesPrice: Int?
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
    dType = Type.RUGS
) {

    override fun toString(): String {
        return "Rug() ${super.toString()}"
    }

}
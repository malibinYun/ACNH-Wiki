package com.malibin.acnh.wiki.data.entity.wearable

import com.malibin.acnh.wiki.data.entity.Item


/**
 * Created By Malibin
 * on 5월 27, 2020
 */

class Wearable(
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
    val closetImage: String,
    val seasonalAvailability: String,
    val style: String,
    val labelThemes: List<String>,
    val variation: String,
    val canVillagerWear: Boolean
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
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Wearable

        if (closetImage != other.closetImage) return false
        if (seasonalAvailability != other.seasonalAvailability) return false
        if (style != other.style) return false
        if (labelThemes != other.labelThemes) return false
        if (variation != other.variation) return false
        if (canVillagerWear != other.canVillagerWear) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + closetImage.hashCode()
        result = 31 * result + seasonalAvailability.hashCode()
        result = 31 * result + style.hashCode()
        result = 31 * result + labelThemes.hashCode()
        result = 31 * result + variation.hashCode()
        result = 31 * result + canVillagerWear.hashCode()
        return result
    }

    override fun toString(): String {
        return "Wearable $dType ${super.toString()} Wearable(dType=$dType, closetImage='$closetImage', seasonalAvailability='$seasonalAvailability', style='$style', labelThemes=$labelThemes, variation='$variation', canVillagerWear=$canVillagerWear)"
    }

}

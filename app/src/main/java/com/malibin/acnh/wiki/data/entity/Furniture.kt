package com.malibin.acnh.wiki.data.entity

// WallMounted
// Miscellaneous
// Housewares

class Furniture(
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
    val canBodyCustom: Boolean,
    val canPatternCustom: Boolean,
    val canPutOutdoor: Boolean
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

        other as Furniture

        if (variantId != other.variantId) return false
        if (variationName != other.variationName) return false
        if (bodyTitle != other.bodyTitle) return false
        if (patternName != other.patternName) return false
        if (patternTitle != other.patternTitle) return false
        if (kitCost != other.kitCost) return false
        if (canBodyCustom != other.canBodyCustom) return false
        if (canPatternCustom != other.canPatternCustom) return false
        if (canPutOutdoor != other.canPutOutdoor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + variantId.hashCode()
        result = 31 * result + variationName.hashCode()
        result = 31 * result + bodyTitle.hashCode()
        result = 31 * result + patternName.hashCode()
        result = 31 * result + patternTitle.hashCode()
        result = 31 * result + kitCost
        result = 31 * result + canBodyCustom.hashCode()
        result = 31 * result + canPatternCustom.hashCode()
        result = 31 * result + canPutOutdoor.hashCode()
        return result
    }

    override fun toString(): String {
        return "Furniture $dType ${super.toString()} (variantId='$variantId', variationName='$variationName', bodyTitle='$bodyTitle', patternName='$patternName', patternTitle='$patternTitle', kitCost=$kitCost, canBodyCustom=$canBodyCustom, canPatternCustom=$canPatternCustom, canPutOutdoor=$canPutOutdoor)"
    }


}
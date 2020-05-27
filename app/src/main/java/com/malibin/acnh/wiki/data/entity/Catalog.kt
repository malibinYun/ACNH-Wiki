package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

@Entity
open class Catalog(
    @PrimaryKey
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
    val milesPrice: Int?,
    var isCollected: Boolean = false,
    var isWished: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Catalog

        if (id != other.id) return false
        if (nameKor != other.nameKor) return false
        if (nameEng != other.nameEng) return false
        if (imageUrl != other.imageUrl) return false
        if (buyCost != other.buyCost) return false
        if (sellPrice != other.sellPrice) return false
        if (source != other.source) return false
        if (sourceNote != other.sourceNote) return false
        if (colors != other.colors) return false
        if (available != other.available) return false
        if (canDiy != other.canDiy) return false
        if (size != other.size) return false
        if (milesPrice != other.milesPrice) return false
        if (isCollected != other.isCollected) return false
        if (isWished != other.isWished) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + nameKor.hashCode()
        result = 31 * result + nameEng.hashCode()
        result = 31 * result + imageUrl.hashCode()
        result = 31 * result + (buyCost ?: 0)
        result = 31 * result + sellPrice
        result = 31 * result + source.hashCode()
        result = 31 * result + sourceNote.hashCode()
        result = 31 * result + colors.hashCode()
        result = 31 * result + available.hashCode()
        result = 31 * result + canDiy.hashCode()
        result = 31 * result + size.hashCode()
        result = 31 * result + (milesPrice ?: 0)
        result = 31 * result + isCollected.hashCode()
        result = 31 * result + isWished.hashCode()
        return result
    }

    override fun toString(): String {
        return "Catalog(id=$id, nameKor='$nameKor', nameEng='$nameEng', imageUrl='$imageUrl', buyCost=$buyCost, sellPrice=$sellPrice, source='$source', sourceNote='$sourceNote', colors=$colors, available='$available', canDiy=$canDiy, size='$size', milesPrice=$milesPrice, isCollected=$isCollected, isWished=$isWished)"
    }
}
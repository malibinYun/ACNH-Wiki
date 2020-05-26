package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity

/**
 * Created By Malibin
 * on 5월 26, 2020
 */

@Entity
class Rug(
    id: Int,
    name: String,
    imageUrl: String,
    buyCost: Int,
    sellPrice: Int,
    source: String,
    sourceNote: String,
    colors: List<String>,
    available: String,
    canDiy: Boolean,
    size: String,
    val hhaConcepts: List<String>,
    val hhaSeries: String,
    val milesPrice: Int?
) : Catalog(
    id,
    name,
    imageUrl,
    buyCost,
    sellPrice,
    source,
    sourceNote,
    colors,
    available,
    canDiy,
    size
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as Rug

        if (hhaConcepts != other.hhaConcepts) return false
        if (hhaSeries != other.hhaSeries) return false
        if (milesPrice != other.milesPrice) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + hhaConcepts.hashCode()
        result = 31 * result + hhaSeries.hashCode()
        result = 31 * result + (milesPrice ?: 0)
        return result
    }

    override fun toString(): String {
        return "Rug ${super.toString()} Rug(hhaConcepts=$hhaConcepts, hhaSeries='$hhaSeries', milesPrice=$milesPrice)"
    }
}
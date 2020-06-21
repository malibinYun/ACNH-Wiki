package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.data.ItemType

/**
 * Created By Malibin
 * on 5월 27, 2020
 */

@Entity
data class Wearable(
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
    val itemType: ItemType,
    val closetImage: String,
    val seasonalAvailability: String,
    val style: String,
    val labelThemes: List<String>,
    val variation: String,
    val canVillagerWear: Boolean,
    var collected: Boolean = false,
    var wished: Boolean = false
) {

    fun toItem() = Item(
        id = id,
        name = nameKor,
        imageUrl = closetImage,
        colors = colors,
        type = itemType,
        isCollected = collected,
        isWished = wished
    )

    companion object {
        val WEARABLE_LIST =
            listOf(
                ItemType.TOPS,
                ItemType.BOTTOMS,
                ItemType.ONEPIECES,
                ItemType.HEADWEARS,
                ItemType.ACCESSORIES,
                ItemType.SOCKS,
                ItemType.SHOES,
                ItemType.BAGS,
                ItemType.UMBRELLAS
            )
    }
}
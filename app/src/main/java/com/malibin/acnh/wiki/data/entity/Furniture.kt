package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.data.ItemType

@Entity
data class Furniture(
    val itemType: ItemType,
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
    val variantId: String,
    val variationName: String,
    val bodyTitle: String,
    val patternName: String,
    val patternTitle: String,
    val kitCost: Int?,
    val canBodyCustom: Boolean,
    val canPatternCustom: Boolean,
    val canPutOutdoor: Boolean,
    var collected: Boolean = false,
    var wished: Boolean = false
) {

    fun toItem() = Item(
        id = id,
        name = nameKor,
        imageUrl = imageUrl,
        colors = colors,
        type = itemType,
        isCollected = collected,
        isWished = wished
    )

    companion object {
        val FURNITURE_LIST =
            listOf(
                ItemType.WALL_MOUNTEDS,
                ItemType.MISCELLANEOUS,
                ItemType.HOUSEWARES,
                ItemType.RUGS
            )
    }
}
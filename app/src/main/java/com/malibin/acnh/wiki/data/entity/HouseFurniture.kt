package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.malibin.acnh.wiki.data.ItemType

// Rug
// Floor
// Wallpaper

@Entity
data class HouseFurniture(
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
    var collected: Boolean = false,
    var wished: Boolean = false
)
package com.malibin.acnh.wiki.data.util

import androidx.room.TypeConverter
import com.malibin.acnh.wiki.data.ItemType

/**
 * Created By Malibin
 * on 6월 13, 2020
 */

class ItemTypeConverter {

    @TypeConverter
    fun toItemType(value: String?): ItemType? = enumValueOf<ItemType>(value ?: "")

    @TypeConverter
    fun fromItemType(itemType: ItemType?): String? = itemType?.name

}
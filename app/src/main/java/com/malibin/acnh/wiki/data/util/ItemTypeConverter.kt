package com.malibin.acnh.wiki.data.util

import androidx.room.TypeConverter
import com.malibin.acnh.wiki.data.entity.Item

/**
 * Created By Malibin
 * on 6월 13, 2020
 */
class ItemTypeConverter {

    @TypeConverter
    fun toItemType(typeString: String): Item.Type? = Item.Type.valueOf(typeString)

    @TypeConverter
    fun fromItemType(type: Item.Type?): String = type?.name ?: ""

}
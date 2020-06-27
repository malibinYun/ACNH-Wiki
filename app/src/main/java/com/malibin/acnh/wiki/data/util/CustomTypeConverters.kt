package com.malibin.acnh.wiki.data.util

import android.text.TextUtils
import androidx.room.TypeConverter
import com.malibin.acnh.wiki.data.ItemType
import java.util.*

/**
 * Created By Malibin
 * on 6월 27, 2020
 */

class CustomTypeConverters {

    @TypeConverter
    fun toDate(milliseconds: Long?): Date? = milliseconds?.let { Date(it) }

    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.time

    @TypeConverter
    fun toItemType(value: String?): ItemType? = enumValueOf<ItemType>(value ?: "")

    @TypeConverter
    fun fromItemType(itemType: ItemType?): String? = itemType?.name

    @TypeConverter
    fun toListString(csvString: String): List<String> = csvString.split(DELIMITER)

    @TypeConverter
    fun fromListString(stringList: List<String>): String = TextUtils.join(DELIMITER, stringList)

    @TypeConverter
    fun toListInt(csvInt: String): List<Int> = csvInt.split(DELIMITER).map { it.toInt() }

    @TypeConverter
    fun fromListInt(intList: List<Int>): String = TextUtils.join(DELIMITER, intList)

    companion object {
        private const val DELIMITER = ","
    }
}
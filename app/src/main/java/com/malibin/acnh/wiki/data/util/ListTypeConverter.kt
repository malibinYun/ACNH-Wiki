package com.malibin.acnh.wiki.data.util

import android.text.TextUtils
import androidx.room.TypeConverter

/**
 * Created By Yun Hyeok
 * on 5월 25, 2020
 */

class ListTypeConverter {

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
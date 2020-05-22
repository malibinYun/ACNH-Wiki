package com.malibin.acnh.wiki.data.util

import androidx.room.TypeConverter
import java.util.*

/**
 * Created By Yun Hyeok
 * on 5월 22, 2020
 */

class DateTypeConverter {

    @TypeConverter
    fun toDate(milliseconds: Long?): Date? = milliseconds?.let { Date(it) }

    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.time

}
package com.malibin.acnh.wiki.data.textparser

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.HouseInterior

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

class HouseInteriorTextParser {
    companion object {
        private const val YES = "Yes"

        fun convertToHouseInteriorList(rawData: String, itemType: ItemType): List<HouseInterior> {
            return rawData.split("\n")
                .run { subList(1, this.size - 1) }
                .map { convertToHouseInterior(it.split("\t"), itemType) }
        }

        private fun convertToHouseInterior(
            cursor: List<String>,
            itemType: ItemType
        ): HouseInterior {
            val colors = ArrayList<String>()
            if (cursor[8].isNotBlank()) colors.add(cursor[8])
            if (cursor[9].isNotBlank()) colors.add(cursor[9])
            return HouseInterior(
                itemType = itemType,
                nameKor = cursor[0],
                id = cursor[1].toInt(),
                nameEng = cursor[2],
                imageUrl = cursor[3],
                buyCost = cursor[4].toIntOrNull(),
                sellPrice = cursor[5].toInt(),
                source = cursor[6],
                sourceNote = cursor[7],
                colors = colors.distinct(),
                available = cursor[10],
                canDiy = cursor[11] == YES,
                size = cursor[12],
                milesPrice = cursor[13].toIntOrNull()
            )
        }
    }
}
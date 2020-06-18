package com.malibin.acnh.wiki.data.textparser

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Wearable

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class WearableTextParser {
    companion object {
        private const val YES = "Yes"

        fun convert(rawData: String, itemType: ItemType): List<Wearable> {
            return rawData.split("\n")
                .run { subList(1, this.size - 1) }
                .map { convertToWearable(it.split("\t"), itemType) }
        }

        private fun convertToWearable(
            cursor: List<String>,
            itemType: ItemType
        ): Wearable {
            val colors = ArrayList<String>()
            if (cursor[8].isNotBlank()) colors.add(cursor[8])
            if (cursor[9].isNotBlank()) colors.add(cursor[9])
            return Wearable(
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
                milesPrice = cursor[13].toIntOrNull(),
                closetImage = cursor[14],
                seasonalAvailability = cursor[15],
                style = cursor[16],
                labelThemes = cursor[17].split(";"),
                variation = cursor[18],
                canVillagerWear = cursor[19] == YES
            )
        }
    }
}
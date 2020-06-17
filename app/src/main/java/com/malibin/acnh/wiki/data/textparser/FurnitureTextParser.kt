package com.malibin.acnh.wiki.data.textparser

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Furniture

/**
 * Created By Malibin
 * on 6월 15, 2020
 */

class FurnitureTextParser {
    companion object {
        private const val YES = "Yes"

        fun convert(rawData: String, itemType: ItemType): List<Furniture> {
            return rawData.split("\n")
                .run { subList(1, this.size - 1) }
                .map { convertToFurniture(it.split("\t"), itemType) }
        }

        private fun convertToFurniture(
            cursor: List<String>,
            itemType: ItemType
        ): Furniture {
            if (itemType == ItemType.RUGS) {
                return rugToFurniture(cursor, itemType)
            }
            val colors = ArrayList<String>()
            if (cursor[8].isNotBlank()) colors.add(cursor[8])
            if (cursor[9].isNotBlank()) colors.add(cursor[9])
            return Furniture(
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
                variantId = cursor[14],
                variationName = cursor[15],
                bodyTitle = cursor[16],
                patternName = cursor[17],
                patternTitle = cursor[18],
                kitCost = cursor[19].toIntOrNull(),
                canBodyCustom = cursor[20] == YES,
                canPatternCustom = cursor[21] == YES,
                canPutOutdoor = cursor[22] == YES
            )
        }

        private fun rugToFurniture(
            cursor: List<String>,
            itemType: ItemType
        ): Furniture {
            val colors = ArrayList<String>()
            if (cursor[8].isNotBlank()) colors.add(cursor[8])
            if (cursor[9].isNotBlank()) colors.add(cursor[9])
            return Furniture(
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
                variantId = "",
                variationName = "",
                bodyTitle = "",
                patternName = "",
                patternTitle = "",
                kitCost = null,
                canBodyCustom = false,
                canPatternCustom = false,
                canPutOutdoor = false
            )
        }
    }
}
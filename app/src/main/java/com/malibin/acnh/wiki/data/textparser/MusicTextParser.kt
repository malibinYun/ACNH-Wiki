package com.malibin.acnh.wiki.data.textparser

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Music

/**
 * Created By Malibin
 * on 6월 19, 2020
 */

class MusicTextParser {
    companion object {
        private const val YES = "Yes"

        fun convert(rawData: String, itemType: ItemType): List<Music> {
            return rawData.split("\n")
                .run { subList(1, this.size - 1) }
                .map { convertToMusic(it.split("\t"), itemType) }
        }

        private fun convertToMusic(
            cursor: List<String>,
            itemType: ItemType
        ): Music {
            val colors = ArrayList<String>()
            if (cursor[8].isNotBlank()) colors.add(cursor[8])
            if (cursor[9].isNotBlank()) colors.add(cursor[9])
            return Music(
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
                albumImageUrl = cursor[14]
            )
        }
    }
}
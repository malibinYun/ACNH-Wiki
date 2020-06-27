package com.malibin.acnh.wiki.data.textparser

import com.malibin.acnh.wiki.data.entity.Villager
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created By Malibin
 * on 6월 19, 2020
 */

class VillagerTextParser {
    companion object {
        private const val DELIMITER = ";"
        private val dateParser = SimpleDateFormat("MM'월' dd'일'", Locale.KOREA)

        fun convert(rawData: String): List<Villager> {
            return rawData.split("\n")
                .run { subList(1, this.size - 1) }
                .map { convertToVillager(it.split("\t")) }
        }

        private fun convertToVillager(
            cursor: List<String>
        ): Villager {
            return Villager(
                amiiboIndex = cursor[0].toInt(),
                nameKor = cursor[1],
                nameJpn = cursor[2],
                nameEng = cursor[3],
                gender = cursor[4],
                birth = dateParser.parse(cursor[5])!!,
                personality = cursor[6],
                species = cursor[7],
                phraseKor = cursor[8],
                phraseEng = cursor[9],
                coffeeBeans = cursor[10],
                milkAmount = cursor[11],
                sugarCount = cursor[12].toInt(),
                hobby = cursor[13],
                likeMusic = cursor[14],
                likeStyles = cursor[15].split(DELIMITER),
                likeColors = cursor[16].split(DELIMITER),
                wallPaper = cursor[17],
                floor = cursor[18],
                furnitureIds = cursor[19].split(DELIMITER).map { (it + "00").toInt() },
                amiiboCardUrl = cursor[20],
                detailUrl = cursor[21],
                exteriorUrl = cursor[22],
                interiorUrl = cursor[23],
                iconUrl = cursor[24],
                posterUrl = cursor[25]
            )
        }
    }
}

package com.malibin.acnh.wiki.data.response

import com.malibin.acnh.wiki.data.entity.Villager
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Yun Hyeok
 * on 5월 22, 2020
 */

data class FVillager(
    val amiiboIndex: Int,
    val nameKor: String,
    val nameJpn: String,
    val nameEng: String,
    val gender: String,
    val birth: String,
    val personality: String,
    val species: String,
    val phraseKor: String,
    val phraseEng: String,
    val coffeeBeans: String,
    val milkAmount: String,
    val sugarCount: Int,
    val hobby: String,
    val likeMusic: String,
    val likeStyles: List<String>,
    val likeColors: List<String>,
    val wallPaper: String,
    val floor: String,
    val furnitureIds: List<Int>,
    val amiiboCardUrl: String,
    val detailUrl: String,
    val exteriorUrl: String,
    val interiorUrl: String,
    val iconUrl: String,
    val posterUrl: String
) {
    constructor() : this(
        -1,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        -1,
        "",
        "",
        listOf(),
        listOf(),
        "",
        "",
        listOf(),
        "",
        "",
        "",
        "",
        "",
        ""
    )

    fun toVillager() = Villager(
        amiiboIndex,
        nameKor,
        nameJpn,
        nameEng,
        gender,
        SimpleDateFormat("MM'월' dd'일'", Locale.KOREA).parse(birth)!!,
        personality,
        species,
        phraseKor,
        phraseEng,
        coffeeBeans,
        milkAmount,
        sugarCount,
        hobby,
        likeMusic,
        likeStyles,
        likeColors,
        wallPaper,
        floor,
        furnitureIds,
        amiiboCardUrl,
        detailUrl,
        exteriorUrl,
        interiorUrl,
        iconUrl,
        posterUrl
    )
}

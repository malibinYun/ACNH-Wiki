package com.malibin.acnh.wiki.data.entity

import androidx.room.Entity
import java.util.*

/**
 * Created By Yun Hyeok
 * on 5월 22, 2020
 */

@Entity
data class Villager(
    val amiiboIndex: Int,
    val nameKor: String,
    val nameJpn: String,
    val nameEng: String,
    val gender: String,
    val birth: Date,
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
    val posterUrl: String,
    var isInHome: Boolean = false,
    var isFavorite: Boolean = false
) {
    companion object {
        const val MALE = "m"
        const val FEMALE = "f"
    }
}






























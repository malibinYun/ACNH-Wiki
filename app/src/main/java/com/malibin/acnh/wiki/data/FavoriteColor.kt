package com.malibin.acnh.wiki.data

import androidx.annotation.ColorRes
import com.malibin.acnh.wiki.R

/**
 * Created By Malibin
 * on 6월 27, 2020
 */

enum class FavoriteColor(private val key: String, @ColorRes val colorRes: Int) {
    RED("빨간색", R.color.favoriteColorRed),
    ORANGE("주황색", R.color.favoriteColorOrange),
    YELLOW("노란색", R.color.favoriteColorYellow),
    GREEN("초록색", R.color.favoriteColorGreen),
    LIGHT_BLUE("하늘색", R.color.favoriteColorLightBlue),
    BLUE("파란색", R.color.favoriteColorBlue),
    PURPLE("보라색", R.color.favoriteColorPurple),
    PINK("분홍색", R.color.favoriteColorPink),
    BROWN("갈색", R.color.favoriteColorBrown),
    BEIGE("베이지색", R.color.favoriteColorBeige),
    BLACK("검정색", R.color.favoriteColorBlack),
    GRAY("회색", R.color.favoriteColorGray),
    WHITE("하얀색", R.color.favoriteColorWhite),
    COLORFUL("컬러풀", R.color.favoriteColorColorful);

    companion object {
        fun findByKey(key: String) = values().first { it.key == key }
    }
}

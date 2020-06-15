package com.malibin.acnh.wiki.data

/**
 * Created By Malibin
 * on 6월 15, 2020
 */

enum class ItemType(val korName: String) {
    FENCES("울타리"),
    MUSICS("음악"),
    POSTERS("포스터"),
    PHOTOS("사진"),
    TOOLS("도구"),
    RUGS("러그"),
    FLOORS("바닥"),
    WALLPAPERS("벽지"),
    WALL_MOUNTEDS("벽걸이"),
    MISCELLANEOUS("잡화"),
    HOUSEWARES("가구"),
    TOPS("상의"),
    BOTTOMS("하의"),
    ONEPIECES("한벌옷"),
    HEADWEARS("모자"),
    ACCESSORIES("액세서리"),
    SOCKS("양말"),
    SHOES("신발"),
    BAGS("가방"),
    UMBRELLAS("우산");
}

fun ItemType.getRemoteLocation(): String {
    return "item/item_${this.korName}"
}
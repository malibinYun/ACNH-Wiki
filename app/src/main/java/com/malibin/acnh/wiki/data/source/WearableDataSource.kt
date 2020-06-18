package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.entity.Wearable

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

interface WearableDataSource : ItemDataSource<Wearable>, MultiItemTypeSource<Wearable> {

    suspend fun findItemsByName(itemName: String): List<Wearable>

}
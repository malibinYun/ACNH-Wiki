package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.ItemType

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

interface MultiItemTypeSource<T> {

    suspend fun getItemTypes(): List<ItemType>

    suspend fun getItemsOf(itemType: ItemType): List<T>

    suspend fun getCollectedItemsOf(itemType: ItemType): List<T>

    suspend fun getWishedItemsOf(itemType: ItemType): List<T>

}
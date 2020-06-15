package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.ItemType

/**
 * Created By Malibin
 * on 6월 15, 2020
 */

interface ItemDataSource<T> {

    suspend fun getAllItems(): List<T>

    suspend fun getItemsOf(itemType: ItemType): List<T>

    suspend fun getItemsOf(specificIds: List<Int>): List<T>

    suspend fun getCollectedItemsOf(itemType: ItemType): List<T>

    suspend fun getCollectedItems(): List<T>

    suspend fun getWishedItemsOf(itemType: ItemType): List<T>

    suspend fun getWishedItems(): List<T>

    suspend fun saveItems(itemList: List<T>)

    suspend fun deleteAllItems()

    suspend fun checkCollected(item: T, isChecked: Boolean)

    suspend fun checkWished(item: T, isChecked: Boolean)

}
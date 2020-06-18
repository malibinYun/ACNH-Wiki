package com.malibin.acnh.wiki.data.source

/**
 * Created By Malibin
 * on 6월 15, 2020
 */

interface ItemDataSource<T> {

    suspend fun getAllItems(): List<T>

    suspend fun findItemById(id: Int): T?

    suspend fun getCollectedItems(): List<T>

    suspend fun getWishedItems(): List<T>

    suspend fun saveItems(itemList: List<T>)

    suspend fun deleteAllItems()

    suspend fun checkCollected(item: T, isChecked: Boolean)

    suspend fun checkWished(item: T, isChecked: Boolean)

}
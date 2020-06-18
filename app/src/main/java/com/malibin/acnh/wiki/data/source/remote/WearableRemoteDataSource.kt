package com.malibin.acnh.wiki.data.source.remote

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Wearable
import com.malibin.acnh.wiki.data.entity.Wearable.Companion.WEARABLE_LIST
import com.malibin.acnh.wiki.data.source.WearableDataSource
import com.malibin.acnh.wiki.data.textparser.WearableTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class WearableRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : WearableDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        throw UnsupportedOperationException("Cannot call getItemTypes in remote source")
    }

    override suspend fun getAllItems(): List<Wearable> {
        return WEARABLE_LIST.flatMap { itemType -> getItemsOf(itemType) }
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Wearable> {
        if (!WEARABLE_LIST.contains(itemType)) {
            throw IllegalArgumentException("Wearable only have $WEARABLE_LIST. $itemType is not contain")
        }
        val rawText = firebaseStorage.getRawItemTextOf(itemType)
        return WearableTextParser.convert(rawText, itemType)
    }

    override suspend fun findItemsByName(itemName: String): List<Wearable> {
        throw UnsupportedOperationException("Cannot call findItemsByName in remote source")
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Wearable> {
        throw UnsupportedOperationException("Cannot call getCollectedItemsOf in remote source")
    }

    override suspend fun getCollectedItems(): List<Wearable> {
        throw UnsupportedOperationException("Cannot call getCollectedItems in remote source")
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Wearable> {
        throw UnsupportedOperationException("Cannot call getWishedItemsOf in remote source")
    }

    override suspend fun getWishedItems(): List<Wearable> {
        throw UnsupportedOperationException("Cannot call getWishedItems in remote source")
    }

    override suspend fun saveItems(itemList: List<Wearable>) {
        throw UnsupportedOperationException("Cannot call saveItems in remote source")
    }

    override suspend fun deleteAllItems() {
        throw UnsupportedOperationException("Cannot call deleteAllItems in remote source")
    }

    override suspend fun checkCollected(item: Wearable, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkCollected in remote source")
    }

    override suspend fun checkWished(item: Wearable, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkWished in remote source")
    }
}
package com.malibin.acnh.wiki.data.source.remote

import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Wearable
import com.malibin.acnh.wiki.data.entity.Wearable.Companion.WEARABLE_LIST
import com.malibin.acnh.wiki.data.source.WearablesDataSource
import com.malibin.acnh.wiki.data.textparser.WearableTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class WearablesRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : WearablesDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        throw UnsupportedOperationException("Cannot call getItemTypes in remote source")
    }

    override suspend fun getAllItems(): List<Wearable> {
        Log.d("Malibin Debug","getAllItems Loaded from remote")
        return WEARABLE_LIST.flatMap { itemType -> getItemsOf(itemType) }
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Wearable> {
        Log.d("Malibin Debug","getItemsOf Loaded from remote")
        if (!WEARABLE_LIST.contains(itemType)) {
            throw IllegalArgumentException("Wearable only have $WEARABLE_LIST. $itemType is not contain")
        }
        val rawText = firebaseStorage.getRawItemTextOf(itemType)
        return WearableTextParser.convert(rawText, itemType)
    }

    override suspend fun findItemById(id: Int): Wearable? {
        throw UnsupportedOperationException("Cannot call findItemById in remote source")
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
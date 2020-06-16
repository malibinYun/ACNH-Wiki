package com.malibin.acnh.wiki.data.source.remote

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Furniture
import com.malibin.acnh.wiki.data.entity.Furniture.Companion.FURNITURE_LIST
import com.malibin.acnh.wiki.data.source.FurnitureDataSource
import com.malibin.acnh.wiki.data.textparser.FurnitureTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Malibin
 * on 6월 15, 2020
 */

class FurnitureRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : FurnitureDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        throw UnsupportedOperationException("Cannot call getItemTypes in remote source")
    }

    override suspend fun getAllItems(): List<Furniture> {
        return FURNITURE_LIST.flatMap { itemType -> getItemsOf(itemType) }
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Furniture> {
        if (!FURNITURE_LIST.contains(itemType)) {
            throw IllegalArgumentException("Furniture only have $FURNITURE_LIST. $itemType is not contain")
        }
        val rawText = firebaseStorage.getRawItemTextOf(itemType)
        return FurnitureTextParser.convertToFurnitureList(rawText, itemType)
    }

    override suspend fun getItemsOf(specificIds: List<Int>): List<Furniture> {
        throw UnsupportedOperationException("Cannot call getItemsOf(specificIds) in remote source")
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Furniture> {
        throw UnsupportedOperationException("Cannot call getCollectedItemsOf in remote source")
    }

    override suspend fun getCollectedItems(): List<Furniture> {
        throw UnsupportedOperationException("Cannot call getCollectedItems in remote source")
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Furniture> {
        throw UnsupportedOperationException("Cannot call getWishedItemsOf in remote source")
    }

    override suspend fun getWishedItems(): List<Furniture> {
        throw UnsupportedOperationException("Cannot call getWishedItems in remote source")
    }

    override suspend fun saveItems(itemList: List<Furniture>) {
        throw UnsupportedOperationException("Cannot call saveItems in remote source")
    }

    override suspend fun deleteAllItems() {
        throw UnsupportedOperationException("Cannot call deleteAllItems in remote source")
    }

    override suspend fun checkCollected(item: Furniture, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkCollected in remote source")
    }

    override suspend fun checkWished(item: Furniture, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkWished in remote source")
    }

}
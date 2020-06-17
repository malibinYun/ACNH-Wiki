package com.malibin.acnh.wiki.data.source.remote

import com.google.firebase.storage.FirebaseStorage
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.HouseInterior
import com.malibin.acnh.wiki.data.entity.HouseInterior.Companion.HOUSE_INTERIOR_LIST
import com.malibin.acnh.wiki.data.source.HouseInteriorDataSource
import com.malibin.acnh.wiki.data.textparser.HouseInteriorTextParser
import com.malibin.acnh.wiki.data.util.getRawItemTextOf

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

class HouseInteriorRemoteDataSource(
    private val firebaseStorage: FirebaseStorage
) : HouseInteriorDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        throw UnsupportedOperationException("Cannot call getItemTypes in remote source")
    }

    override suspend fun getAllItems(): List<HouseInterior> {
        return HOUSE_INTERIOR_LIST.flatMap { itemType -> getItemsOf(itemType) }
    }

    override suspend fun getItemsOf(itemType: ItemType): List<HouseInterior> {
        if (!HOUSE_INTERIOR_LIST.contains(itemType)) {
            throw IllegalArgumentException("HouseInterior only have ${HOUSE_INTERIOR_LIST}. $itemType is not contain")
        }
        val rawText = firebaseStorage.getRawItemTextOf(itemType)
        return HouseInteriorTextParser.convert(rawText, itemType)
    }

    override suspend fun fetchItem(itemName: String) {

    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<HouseInterior> {
        throw UnsupportedOperationException("Cannot call getCollectedItemsOf in remote source")
    }

    override suspend fun getCollectedItems(): List<HouseInterior> {
        throw UnsupportedOperationException("Cannot call getCollectedItems in remote source")
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<HouseInterior> {
        throw UnsupportedOperationException("Cannot call getWishedItemsOf in remote source")
    }

    override suspend fun getWishedItems(): List<HouseInterior> {
        throw UnsupportedOperationException("Cannot call getWishedItems in remote source")
    }

    override suspend fun saveItems(itemList: List<HouseInterior>) {
        throw UnsupportedOperationException("Cannot call saveItems in remote source")
    }

    override suspend fun deleteAllItems() {
        throw UnsupportedOperationException("Cannot call deleteAllItems in remote source")
    }

    override suspend fun checkCollected(item: HouseInterior, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkCollected in remote source")
    }

    override suspend fun checkWished(item: HouseInterior, isChecked: Boolean) {
        throw UnsupportedOperationException("Cannot call checkWished in remote source")
    }

}
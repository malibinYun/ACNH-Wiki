package com.malibin.acnh.wiki.data.source.local

import android.util.Log
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.dao.WearableDao
import com.malibin.acnh.wiki.data.entity.Wearable
import com.malibin.acnh.wiki.data.source.WearablesDataSource

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class WearablesLocalDataSource(
    private val wearableDao: WearableDao
) : WearablesDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        return wearableDao.getItemTypes()
    }

    override suspend fun getAllItems(): List<Wearable> {
        Log.d("Malibin Debug", "getAllItems Loaded from local")
        return wearableDao.getAllWearables()
    }

    override suspend fun findItemById(id: Int): Wearable? {
        return wearableDao.findWearableById(id)
    }

    override suspend fun findItemsByName(itemName: String): List<Wearable> {
        return wearableDao.findWearablesOf(itemName)
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Wearable> {
        Log.d("Malibin Debug", "getItemsOf Loaded from local")
        return wearableDao.findWearablesOf(itemType)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Wearable> {
        return wearableDao.getCollectedWearablesOf(itemType)
    }

    override suspend fun getCollectedItems(): List<Wearable> {
        return wearableDao.getCollectedWearables()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Wearable> {
        return wearableDao.getWishedWearablesOf(itemType)
    }

    override suspend fun getWishedItems(): List<Wearable> {
        return wearableDao.getWishedWearables()
    }

    override suspend fun saveItems(itemList: List<Wearable>) {
        Log.d("Malibin Debug", "saveItems")
        wearableDao.insertWearables(itemList)
    }

    override suspend fun deleteAllItems() {
        wearableDao.deleteAllWearables()
    }

    override suspend fun checkCollected(item: Wearable, isChecked: Boolean) {
        wearableDao.updateWearableCollected(item.id, isChecked)
    }

    override suspend fun checkWished(item: Wearable, isChecked: Boolean) {
        wearableDao.updateWearableWished(item.id, isChecked)
    }

}
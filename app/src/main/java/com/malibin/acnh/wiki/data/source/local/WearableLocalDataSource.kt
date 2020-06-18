package com.malibin.acnh.wiki.data.source.local

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.dao.WearableDao
import com.malibin.acnh.wiki.data.entity.Wearable
import com.malibin.acnh.wiki.data.source.WearableDataSource

/**
 * Created By Malibin
 * on 6월 18, 2020
 */

class WearableLocalDataSource(
    private val wearableDao: WearableDao
) : WearableDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        return wearableDao.getItemTypes()
    }

    override suspend fun getAllItems(): List<Wearable> {
        return wearableDao.getAllWearables()
    }

    override suspend fun findItemsByName(itemName: String): List<Wearable> {
        return wearableDao.getWearablesOf(itemName)
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Wearable> {
        return wearableDao.getWearablesOf(itemType)
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
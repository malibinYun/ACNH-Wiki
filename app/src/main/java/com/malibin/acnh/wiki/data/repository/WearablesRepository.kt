package com.malibin.acnh.wiki.data.repository

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Wearable
import com.malibin.acnh.wiki.data.entity.Wearable.Companion.WEARABLE_LIST
import com.malibin.acnh.wiki.data.source.WearablesDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

class WearablesRepository(
    private val wearablesLocalDataSource: WearablesDataSource,
    private val wearablesRemoteDataSource: WearablesDataSource
) : WearablesDataSource {

    private val itemTypesCache = mutableListOf<ItemType>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            itemTypesCache.addAll(getItemTypes())
        }
    }

    override suspend fun getItemTypes(): List<ItemType> {
        return wearablesLocalDataSource.getItemTypes()
    }

    @Synchronized
    override suspend fun getAllItems(): List<Wearable> {
        if (itemTypesCache.size == WEARABLE_LIST.size) {
            return wearablesLocalDataSource.getAllItems()
        }
        val remoteAllItems = wearablesRemoteDataSource.getAllItems()
        wearablesLocalDataSource.saveItems(remoteAllItems)
        itemTypesCache.addAll(WEARABLE_LIST)
        return remoteAllItems
    }

    @Synchronized
    override suspend fun getItemsOf(itemType: ItemType): List<Wearable> {
        if (itemTypesCache.contains(itemType)) {
            return wearablesLocalDataSource.getItemsOf(itemType)
        }
        itemTypesCache.add(itemType)
        val specificTypeOfWearable = wearablesRemoteDataSource.getItemsOf(itemType)
        wearablesLocalDataSource.saveItems(specificTypeOfWearable)
        return wearablesLocalDataSource.getItemsOf(itemType)
    }

    override suspend fun findItemsByName(itemName: String): List<Wearable> {
        return wearablesLocalDataSource.findItemsByName(itemName)
    }

    override suspend fun findItemById(id: Int): Wearable? {
        return wearablesLocalDataSource.findItemById(id)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Wearable> {
        return wearablesLocalDataSource.getCollectedItemsOf(itemType)
    }

    override suspend fun getCollectedItems(): List<Wearable> {
        return wearablesLocalDataSource.getCollectedItems()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Wearable> {
        return wearablesLocalDataSource.getWishedItemsOf(itemType)
    }

    override suspend fun getWishedItems(): List<Wearable> {
        return wearablesLocalDataSource.getWishedItems()
    }

    override suspend fun saveItems(itemList: List<Wearable>) {
        throw UnsupportedOperationException("cannot call saveItems in repository")
    }

    override suspend fun deleteAllItems() {
        wearablesLocalDataSource.deleteAllItems()
    }

    override suspend fun checkCollected(item: Wearable, isChecked: Boolean) {
        wearablesLocalDataSource.checkCollected(item, isChecked)
    }

    override suspend fun checkWished(item: Wearable, isChecked: Boolean) {
        wearablesLocalDataSource.checkWished(item, isChecked)
    }
}
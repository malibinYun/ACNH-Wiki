package com.malibin.acnh.wiki.data.repository

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.Furniture
import com.malibin.acnh.wiki.data.entity.Furniture.Companion.FURNITURE_LIST
import com.malibin.acnh.wiki.data.source.FurnitureDataSource
import com.malibin.acnh.wiki.data.source.ItemDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

class FurnitureRepository(
    private val furnitureLocalDataSource: FurnitureDataSource,
    private val furnitureRemoteDataSource: FurnitureDataSource
) : FurnitureDataSource {

    private val itemTypesCache = mutableSetOf<ItemType>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            itemTypesCache.addAll(getItemTypes())
        }
    }

    override suspend fun getItemTypes(): List<ItemType> {
        return furnitureLocalDataSource.getItemTypes()
    }

    @Synchronized
    override suspend fun getAllItems(): List<Furniture> {
        if (itemTypesCache.size == FURNITURE_LIST.size) {
            return furnitureLocalDataSource.getAllItems()
        }
        val allFurniture = furnitureRemoteDataSource.getAllItems()
        furnitureLocalDataSource.saveItems(allFurniture)
        itemTypesCache.addAll(FURNITURE_LIST)
        return allFurniture
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Furniture> {
        if (itemTypesCache.contains(itemType)) {
            return furnitureLocalDataSource.getItemsOf(itemType)
        }
        itemTypesCache.add(itemType)
        val specificTypeOfFurniture = furnitureRemoteDataSource.getItemsOf(itemType)
        saveItems(specificTypeOfFurniture)
        return specificTypeOfFurniture
    }

    @Synchronized
    override suspend fun getItemsOf(specificIds: List<Int>): List<Furniture> {
        if (itemTypesCache.size < FURNITURE_LIST.size) {
            getAllItems()
        }
        return furnitureLocalDataSource.getItemsOf(specificIds)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Furniture> {
        return furnitureLocalDataSource.getCollectedItemsOf(itemType)
    }

    override suspend fun getCollectedItems(): List<Furniture> {
        return furnitureLocalDataSource.getCollectedItems()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Furniture> {
        return furnitureLocalDataSource.getWishedItemsOf(itemType)
    }

    override suspend fun getWishedItems(): List<Furniture> {
        return furnitureLocalDataSource.getWishedItems()
    }

    override suspend fun saveItems(itemList: List<Furniture>) {
        furnitureLocalDataSource.saveItems(itemList)
    }

    override suspend fun deleteAllItems() {
        furnitureLocalDataSource.deleteAllItems()
    }

    override suspend fun checkCollected(item: Furniture, isChecked: Boolean) {
        furnitureLocalDataSource.checkCollected(item, isChecked)
    }

    override suspend fun checkWished(item: Furniture, isChecked: Boolean) {
        furnitureLocalDataSource.checkWished(item, isChecked)
    }
}
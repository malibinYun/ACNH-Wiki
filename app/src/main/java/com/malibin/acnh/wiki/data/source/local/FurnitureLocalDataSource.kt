package com.malibin.acnh.wiki.data.source.local

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.dao.FurnitureDao
import com.malibin.acnh.wiki.data.entity.Furniture
import com.malibin.acnh.wiki.data.source.ItemDataSource

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

class FurnitureLocalDataSource(
    private val furnitureDao: FurnitureDao
) : ItemDataSource<Furniture> {

    override suspend fun getItemTypes(): List<ItemType> {
        return furnitureDao.getItemTypes()
    }

    override suspend fun getAllItems(): List<Furniture> {
        return furnitureDao.getAllFurniture()
    }

    override suspend fun getItemsOf(itemType: ItemType): List<Furniture> {
        return furnitureDao.getFurnitureListOf(itemType)
    }

    override suspend fun getItemsOf(specificIds: List<Int>): List<Furniture> {
        return furnitureDao.getFurnitureListOf(specificIds)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<Furniture> {
        return furnitureDao.getCollectedFurnitureListOf(itemType)
    }

    override suspend fun getCollectedItems(): List<Furniture> {
        return furnitureDao.getCollectedFurnitureList()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<Furniture> {
        return furnitureDao.getWishedFurnitureListOf(itemType)
    }

    override suspend fun getWishedItems(): List<Furniture> {
        return furnitureDao.getWishedFurnitureList()
    }

    override suspend fun saveItems(itemList: List<Furniture>) {
        furnitureDao.insertFurniture(itemList)
    }

    override suspend fun deleteAllItems() {
        furnitureDao.deleteAllFurniture()
    }

    override suspend fun checkCollected(item: Furniture, isChecked: Boolean) {
        furnitureDao.updateFurnitureCollected(item.id, isChecked)
    }

    override suspend fun checkWished(item: Furniture, isChecked: Boolean) {
        furnitureDao.updateFurnitureWished(item.id, isChecked)
    }
}
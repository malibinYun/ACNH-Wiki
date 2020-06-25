package com.malibin.acnh.wiki.data.repository

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.entity.HouseInterior
import com.malibin.acnh.wiki.data.entity.HouseInterior.Companion.HOUSE_INTERIOR_LIST
import com.malibin.acnh.wiki.data.source.HouseInteriorsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 25, 2020
 */

class HouseInteriorsRepository(
    private val houseInteriorLocalDataSource: HouseInteriorsDataSource,
    private val houseInteriorsRemoteDataSource: HouseInteriorsDataSource
) : HouseInteriorsDataSource {

    private val itemTypesCache = mutableSetOf<ItemType>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            itemTypesCache.addAll(getItemTypes())
        }
    }

    override suspend fun getItemTypes(): List<ItemType> {
        return houseInteriorLocalDataSource.getItemTypes()
    }

    @Synchronized
    override suspend fun getAllItems(): List<HouseInterior> {
        return HOUSE_INTERIOR_LIST.flatMap { this.getItemsOf(it) }
    }

    @Synchronized
    override suspend fun getItemsOf(itemType: ItemType): List<HouseInterior> {
        if (itemTypesCache.contains(itemType)) {
            return houseInteriorLocalDataSource.getItemsOf(itemType)
        }
        itemTypesCache.add(itemType)
        val specificTypeOfHouseInterior = houseInteriorsRemoteDataSource.getItemsOf(itemType)
        houseInteriorLocalDataSource.saveItems(specificTypeOfHouseInterior)
        return specificTypeOfHouseInterior
    }

    override suspend fun findItemById(id: Int): HouseInterior? {
        return houseInteriorLocalDataSource.findItemById(id)
    }

    override suspend fun findItemByName(itemName: String): HouseInterior? {
        return houseInteriorLocalDataSource.findItemByName(itemName)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<HouseInterior> {
        return houseInteriorLocalDataSource.getCollectedItemsOf(itemType)
    }

    override suspend fun getCollectedItems(): List<HouseInterior> {
        return houseInteriorLocalDataSource.getCollectedItems()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<HouseInterior> {
        return houseInteriorLocalDataSource.getWishedItemsOf(itemType)
    }

    override suspend fun getWishedItems(): List<HouseInterior> {
        return houseInteriorLocalDataSource.getWishedItems()
    }

    override suspend fun saveItems(itemList: List<HouseInterior>) {
        throw UnsupportedOperationException("cannot call saveItems in repository")
    }

    override suspend fun deleteAllItems() {
        houseInteriorLocalDataSource.deleteAllItems()
    }

    override suspend fun checkCollected(item: HouseInterior, isChecked: Boolean) {
        houseInteriorLocalDataSource.checkCollected(item, isChecked)
    }

    override suspend fun checkWished(item: HouseInterior, isChecked: Boolean) {
        houseInteriorLocalDataSource.checkWished(item, isChecked)
    }

}
package com.malibin.acnh.wiki.data.source.local

import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.dao.HouseInteriorsDao
import com.malibin.acnh.wiki.data.entity.HouseInterior
import com.malibin.acnh.wiki.data.source.HouseInteriorsDataSource

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

class HouseInteriorLocalDataSource(
    private val houseInteriorsDao: HouseInteriorsDao
) : HouseInteriorsDataSource {

    override suspend fun getItemTypes(): List<ItemType> {
        return houseInteriorsDao.getItemTypes()
    }

    override suspend fun getAllItems(): List<HouseInterior> {
        return houseInteriorsDao.getAllHouseInteriors()
    }

    override suspend fun fetchItem(itemName: String): HouseInterior? {
        return houseInteriorsDao.findHouseInteriorByName(itemName)
    }

    override suspend fun getItemsOf(itemType: ItemType): List<HouseInterior> {
        return houseInteriorsDao.getHouseInteriorsOf(itemType)
    }

    override suspend fun getCollectedItemsOf(itemType: ItemType): List<HouseInterior> {
        return houseInteriorsDao.getCollectedHouseInteriorsOf(itemType)
    }

    override suspend fun getCollectedItems(): List<HouseInterior> {
        return houseInteriorsDao.getCollectedHouseInteriors()
    }

    override suspend fun getWishedItemsOf(itemType: ItemType): List<HouseInterior> {
        return houseInteriorsDao.getWishedHouseInteriorsOf(itemType)
    }

    override suspend fun getWishedItems(): List<HouseInterior> {
        return houseInteriorsDao.getWishedHouseInteriors()
    }

    override suspend fun saveItems(itemList: List<HouseInterior>) {
        houseInteriorsDao.insertHouseInteriors(itemList)
    }

    override suspend fun deleteAllItems() {
        houseInteriorsDao.deleteAllHouseInteriors()
    }

    override suspend fun checkCollected(item: HouseInterior, isChecked: Boolean) {
        houseInteriorsDao.updateHouseInteriorCollected(item.id, isChecked)
    }

    override suspend fun checkWished(item: HouseInterior, isChecked: Boolean) {
        houseInteriorsDao.updateHouseInteriorWished(item.id, isChecked)
    }

}
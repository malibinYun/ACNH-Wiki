package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.entity.Furniture

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

interface FurnitureDataSource : ItemDataSource<Furniture>, MultiItemTypeSource<Furniture> {

    suspend fun getItemsOf(specificIds: List<Int>): List<Furniture>

    suspend fun findItemByName(itemName: String): List<Furniture>

}
package com.malibin.acnh.wiki.data.source

import com.malibin.acnh.wiki.data.entity.HouseInterior

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

interface HouseInteriorDataSource : ItemDataSource<HouseInterior>,
    MultiItemTypeSource<HouseInterior> {

    suspend fun fetchItem(itemName: String)

}
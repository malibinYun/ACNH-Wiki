package com.malibin.acnh.wiki.ui.villager.furniture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.FurnitureRepository
import com.malibin.acnh.wiki.data.repository.HouseInteriorsRepository
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.data.source.remote.HouseInteriorsRemoteDataSource
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 25, 2020
 */

class VillagerFurnitureViewModel(
    private val villagersRepository: VillagersRepository,
    private val interiorsRepository: HouseInteriorsRepository,
    private val furnitureRepository: FurnitureRepository
) : BaseViewModel() {

    private val _villager = MutableLiveData<Villager>()
    val villager: LiveData<Villager>
        get() = _villager

    private val _furnitureList = MutableLiveData<List<Item>>()
    val furnitureList: LiveData<List<Item>>
        get() = _furnitureList

    fun loadVillager(amiiboIndex: Int) = viewModelScope.launch {
        _villager.value = villagersRepository.fetchVillager(amiiboIndex)
        loadFurnitureList()
    }

    private suspend fun loadFurnitureList() {
        _isLoading.value = true
        val villager = getVillager()
        val interiors = getHouseInteriors(villager)
        val furnitureList = getFurniture(villager)
        _furnitureList.value = listOf(interiors, furnitureList).flatten()
        _isLoading.value = false
    }

    private suspend fun getHouseInteriors(villager: Villager): List<Item> {
        val items = mutableListOf<Item>()
        interiorsRepository.findItemByName(villager.wallPaper)?.also { items.add(it.toItem()) }
        interiorsRepository.findItemByName(villager.floor)?.also { items.add(it.toItem()) }
        return items
    }

    private suspend fun getFurniture(villager: Villager): List<Item> {
        return furnitureRepository.getItemsOf(villager.furnitureIds)
            .map { it.toItem() }
    }

    private fun getVillager() = _villager.value
        ?: throw IllegalStateException("villager should be initiated first")

}
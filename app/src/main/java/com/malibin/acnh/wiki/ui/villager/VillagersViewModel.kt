package com.malibin.acnh.wiki.ui.villager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

class VillagersViewModel(
    private val villagersRepository: VillagersRepository
) : BaseViewModel() {

    private val _villagers = MutableLiveData<List<Villager>>()
    val villagers: LiveData<List<Villager>>
        get() = _villagers

    fun loadAllVillagers() = viewModelScope.launch {
        _isLoading.value = true
        _villagers.value = villagersRepository.getAllVillagers()
        _isLoading.value = false
    }

    fun loadFavoriteVillagers() = viewModelScope.launch {
        _isLoading.value = true
        _villagers.value = villagersRepository.getFavoriteVillagers()
        _isLoading.value = false
    }

    fun loadHomeVillagers() = viewModelScope.launch {
        _isLoading.value = true
        _villagers.value = villagersRepository.getVillagersInHome()
        _isLoading.value = false
    }
}

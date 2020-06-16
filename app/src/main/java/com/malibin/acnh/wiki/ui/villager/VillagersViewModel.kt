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

    init {
        loadVillagers()
    }

    private fun loadVillagers() = viewModelScope.launch {
        val villagers = villagersRepository.getAllVillagers()
        _villagers.value = villagers
    }

}

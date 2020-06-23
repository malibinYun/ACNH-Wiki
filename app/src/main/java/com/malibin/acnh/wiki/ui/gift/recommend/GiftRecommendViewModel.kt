package com.malibin.acnh.wiki.ui.gift.recommend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.MusicRepository
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.data.repository.WearablesRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 24, 2020
 */

class GiftRecommendViewModel(
    private val villagersRepository: VillagersRepository,
    private val wearablesRepository: WearablesRepository,
    private val musicRepository: MusicRepository
) : BaseViewModel() {

    private val _villager = MutableLiveData<Villager>()
    val villager: LiveData<Villager>
        get() = _villager

    fun setVillager(amiiboIndex: Int) = viewModelScope.launch {
        if (amiiboIndex == Villager.ERROR_AMIIBO_INDEX) return@launch
        _villager.value = villagersRepository.fetchVillager(amiiboIndex)
    }
}
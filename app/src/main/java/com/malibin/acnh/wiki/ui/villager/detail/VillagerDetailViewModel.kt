package com.malibin.acnh.wiki.ui.villager.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

class VillagerDetailViewModel(
    private val villagersRepository: VillagersRepository
) : BaseViewModel() {

    private val _villager = MutableLiveData<Villager>()
    val villager: LiveData<Villager>
        get() = _villager

    fun loadVillagerOf(amiiboIndex: Int) = viewModelScope.launch {
        Log.d("Malibin Debug", "amiiboIndex : $amiiboIndex")
        _isLoading.value = true
        _villager.value = villagersRepository.fetchVillager(amiiboIndex)
        _isLoading.value = false
    }

}
package com.malibin.acnh.wiki.ui.villager.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

    private val _isInHome = MutableLiveData<Boolean>()
    val isInHome: LiveData<Boolean>
        get() = _isInHome

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun loadVillagerOf(amiiboIndex: Int) = viewModelScope.launch {
        Log.d("Malibin Debug", "amiiboIndex : $amiiboIndex")
        _isLoading.value = true
        _villager.value = villagersRepository.fetchVillager(amiiboIndex)
        _isInHome.value = getCurrentVillager().isInHome
        _isFavorite.value = getCurrentVillager().isFavorite
        _isLoading.value = false
    }

    @Synchronized
    fun onClickVillagerInHome() {
        _isInHome.value = !getCurrentIsInHome()
    }

    @Synchronized
    fun onClickFavorite() {
        _isFavorite.value = !getCurrentIsFavorite()
    }

    fun saveVillagerState() {
        saveIsInHome()
        saveIsFavorite()
    }

    private fun saveIsInHome() = CoroutineScope(Dispatchers.IO).launch {
        val villager = getCurrentVillager()
        val isInHome = getCurrentIsInHome()
        villagersRepository.checkHomeVillager(villager, isInHome)
    }

    private fun saveIsFavorite() = CoroutineScope(Dispatchers.IO).launch {
        val villager = getCurrentVillager()
        val isFavorite = getCurrentIsFavorite()
        villagersRepository.checkFavoriteVillager(villager, isFavorite)
    }

    private fun getCurrentVillager() = villager.value
        ?: throw IllegalStateException("현재 주민은 null일 수 없음.")

    private fun getCurrentIsInHome() = _isInHome.value
        ?: throw IllegalStateException("isInHome 값이 null일 수 없음")

    private fun getCurrentIsFavorite() = _isFavorite.value
        ?: throw IllegalStateException("isFavorite 값이 null일 수 없음")

}
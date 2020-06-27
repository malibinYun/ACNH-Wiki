package com.malibin.acnh.wiki.ui.villager.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

    fun isStateChanged(): Boolean {
        return isInHomeChanged() or isFavoriteChanged()
    }

    private fun saveIsInHome() = runBlocking {
        if (isInHomeChanged()) {
            villagersRepository.checkHomeVillager(getCurrentVillager(), getCurrentIsInHome())
        }
    }

    private fun isInHomeChanged(): Boolean {
        return getCurrentVillager().isInHome != getCurrentIsInHome()
    }

    private fun saveIsFavorite() = runBlocking {
        if (isFavoriteChanged()) {
            villagersRepository.checkFavoriteVillager(getCurrentVillager(), getCurrentIsFavorite())
        }
    }

    private fun isFavoriteChanged(): Boolean {
        return getCurrentVillager().isFavorite != getCurrentIsFavorite()
    }

    private fun getCurrentVillager() = villager.value
        ?: throw IllegalStateException("현재 주민은 null일 수 없음.")

    private fun getCurrentIsInHome() = _isInHome.value
        ?: throw IllegalStateException("isInHome 값이 null일 수 없음")

    private fun getCurrentIsFavorite() = _isFavorite.value
        ?: throw IllegalStateException("isFavorite 값이 null일 수 없음")

}
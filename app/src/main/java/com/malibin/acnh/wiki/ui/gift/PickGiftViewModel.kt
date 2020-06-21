package com.malibin.acnh.wiki.ui.gift

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.data.ItemType
import com.malibin.acnh.wiki.data.repository.MusicRepository
import com.malibin.acnh.wiki.data.repository.WearablesRepository
import com.malibin.acnh.wiki.ui.utils.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

class PickGiftViewModel(
    private val wearableRepository: WearablesRepository,
    private val musicRepository: MusicRepository
) : BaseViewModel() {

    private val _pickedItemType = MutableLiveData<ItemType>()
    val pickedItemType: LiveData<ItemType>
        get() = _pickedItemType

    private val _itemsOfPickedType = MutableLiveData<List<Item>>()
    val itemsOfPickedType: LiveData<List<Item>>
        get() = _itemsOfPickedType

    private val _pickedItemVariations = MutableLiveData<List<Item>>()
    val pickedItemVariations: LiveData<List<Item>>
        get() = _pickedItemVariations

    private val _finalPickedItem = MutableLiveData<Item>()
    val finalPickedItem: LiveData<Item>
        get() = _finalPickedItem

    fun pickItemType(itemType: ItemType) = viewModelScope.launch {
        _isLoading.value = true
        _pickedItemType.value = itemType
        loadItemsOf(itemType)
        _isLoading.value = false
    }

    private suspend fun loadItemsOf(itemType: ItemType) {
        if (itemType == ItemType.MUSICS) {
            _itemsOfPickedType.value = musicRepository.getAllItems().map { it.toItem() }
            return
        }
        _itemsOfPickedType.value = wearableRepository.getItemsOf(itemType).map { it.toItem() }
    }

    fun pickItem(item: Item) = viewModelScope.launch {
        _isLoading.value = true
        if (item.type == ItemType.MUSICS) {
            _pickedItemVariations.value = listOf(item)
            return@launch
        }
        _pickedItemVariations.value =
            wearableRepository.findItemsByName(item.name).map { it.toItem() }
        _isLoading.value = false
    }

    fun pickVariationOfItem(item: Item) {
        _finalPickedItem.value = item
    }

}
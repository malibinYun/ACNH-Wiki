package com.malibin.acnh.wiki.ui.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

open class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

}
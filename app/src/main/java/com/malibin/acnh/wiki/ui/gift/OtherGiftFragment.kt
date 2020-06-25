package com.malibin.acnh.wiki.ui.gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.BottomSheetOtherGiftsBinding

/**
 * Created By Malibin
 * on 6월 23, 2020
 */

class OtherGiftFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.Widget_AppTheme_BottomSheet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = BottomSheetOtherGiftsBinding.inflate(inflater, container, false)
        binding.btnClose.setOnClickListener { dismiss() }
        return binding.root
    }

}
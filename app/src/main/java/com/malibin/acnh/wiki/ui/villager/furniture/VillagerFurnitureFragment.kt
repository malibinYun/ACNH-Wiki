package com.malibin.acnh.wiki.ui.villager.furniture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.malibin.acnh.wiki.databinding.BottomSheetVillagerFurnitureBinding

/**
 * Created By Malibin
 * on 6월 25, 2020
 */

class VillagerFurnitureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = BottomSheetVillagerFurnitureBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setVillagerAmiibo(amiiboIndex: Int) {
        val bundle = Bundle().apply { putInt(AMIIBO_INDEX, amiiboIndex) }
        arguments?.putBundle(AMIIBO_INDEX, bundle)
    }

    companion object {
        private const val AMIIBO_INDEX = "amiibo_index"
    }
}
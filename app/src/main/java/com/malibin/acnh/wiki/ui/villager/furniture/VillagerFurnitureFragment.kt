package com.malibin.acnh.wiki.ui.villager.furniture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.BottomSheetVillagerFurnitureBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created By Malibin
 * on 6월 25, 2020
 */

class VillagerFurnitureFragment : BottomSheetDialogFragment() {

    private val villagerFurnitureViewModel: VillagerFurnitureViewModel by viewModel()
    private lateinit var villagerFurnitureAdapter: VillagerFurnitureAdapter

    override fun getTheme(): Int = R.style.Widget_AppTheme_BottomSheet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = BottomSheetVillagerFurnitureBinding.inflate(inflater, container, false)
        initView(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDialogExpanded()
        subscribeFurniture()
        villagerFurnitureViewModel.loadFurnitureOf(getVillagerAmiibo())
    }

    override fun onDestroy() {
        super.onDestroy()

        villagerFurnitureAdapter.clearItems()
    }

    private fun initView(binding: BottomSheetVillagerFurnitureBinding) {
        villagerFurnitureAdapter = VillagerFurnitureAdapter()
        binding.rvFurnitureList.adapter = villagerFurnitureAdapter
        binding.viewModel = villagerFurnitureViewModel
        binding.lifecycleOwner = this
        binding.btnClose.setOnClickListener { dismiss() }
    }

    private fun setDialogExpanded() {
        dialog?.setOnShowListener {
            val bottomSheetView = (it as BottomSheetDialog).findViewById<FrameLayout>(
                com.google.android.material.R.id.design_bottom_sheet
            )
            if (bottomSheetView != null) {
                BottomSheetBehavior.from(bottomSheetView).state = STATE_EXPANDED
            }
        }
    }

    fun setVillagerAmiibo(amiiboIndex: Int) {
        arguments = Bundle().apply { putInt(AMIIBO_INDEX, amiiboIndex) }
    }

    private fun getVillagerAmiibo() = arguments?.getInt(AMIIBO_INDEX)
        ?: throw IllegalStateException("Amiibo index must be tossed")

    private fun subscribeFurniture() {
        villagerFurnitureViewModel.furnitureList.observe(this, Observer {
            villagerFurnitureAdapter.submitList(it)
        })
    }

    companion object {
        private const val AMIIBO_INDEX = "amiibo_index"
    }
}
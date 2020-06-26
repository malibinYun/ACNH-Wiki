package com.malibin.acnh.wiki.ui.villager.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.entity.Villager.Companion.ERROR_AMIIBO_INDEX
import com.malibin.acnh.wiki.databinding.ActivityVillagerDetailBinding
import com.malibin.acnh.wiki.ui.gift.recommend.GiftRecommendActivity
import com.malibin.acnh.wiki.ui.villager.furniture.VillagerFurnitureFragment
import com.malibin.acnh.wiki.ui.villager.furniture.VillagerFurnitureViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VillagerDetailActivity : AppCompatActivity() {

    private val villagerDetailViewModel: VillagerDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        villagerDetailViewModel.loadVillagerOf(getVillagerAmiiboIndex())

        val binding = ActivityVillagerDetailBinding.inflate(layoutInflater)
        initView(binding)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        saveVillagerState()
        super.onBackPressed()
    }

    private fun initView(binding: ActivityVillagerDetailBinding) {
        binding.villagerViewModel = villagerDetailViewModel
        binding.lifecycleOwner = this
        binding.btnBack.setOnClickListener { onBackPressed() }
        binding.btnRecommendPresent.setOnClickListener { deployGiftRecommendActivity() }
        binding.btnShowFurnitureList.setOnClickListener { showVillagerFurnitureBottomSheet() }
    }

    private fun saveVillagerState() {
        if (villagerDetailViewModel.isStateChanged()) {
            setResult(VILLAGER_STATE_CHANGED, Intent())
        }
        villagerDetailViewModel.saveVillagerState()
    }

    private fun getVillagerAmiiboIndex(): Int {
        val index = intent.getIntExtra(AMIIBO_INDEX, ERROR_AMIIBO_INDEX)
        if (index == ERROR_AMIIBO_INDEX) {
            throw IllegalArgumentException("Amiibo index must be tossed")
        }
        return index
    }

    private fun deployGiftRecommendActivity() {
        val intent = Intent(this, GiftRecommendActivity::class.java)
        intent.putExtra(GiftRecommendActivity.AMIIBO_INDEX, getVillagerAmiiboIndex())
        startActivity(intent)
    }

    private fun showVillagerFurnitureBottomSheet() {
        VillagerFurnitureFragment().apply {
            setVillagerAmiibo(getVillagerAmiiboIndex())
        }.show(supportFragmentManager, null)
    }

    companion object {
        const val AMIIBO_INDEX = "amiiboIndex"
        const val REQUEST_CODE = 1000
        const val VILLAGER_STATE_CHANGED = 100
    }
}
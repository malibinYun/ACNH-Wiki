package com.malibin.acnh.wiki.ui.villager.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.malibin.acnh.wiki.databinding.ActivityVillagerDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VillagerDetailActivity : AppCompatActivity() {

    private val villagerDetailViewModel: VillagerDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.villagerViewModel = villagerDetailViewModel
        binding.lifecycleOwner = this
        villagerDetailViewModel.loadVillagerOf(getAmiiboIndex())
    }

    private fun getAmiiboIndex(): Int {
        val index = intent.getIntExtra(AMIIBO_INDEX, DEFAULT_INDEX)
        if (index == DEFAULT_INDEX) {
            throw IllegalArgumentException("Amiibo index must be tossed")
        }
        return index
    }

    companion object {
        private const val DEFAULT_INDEX = -1
        const val AMIIBO_INDEX = "amiiboIndex"
    }
}
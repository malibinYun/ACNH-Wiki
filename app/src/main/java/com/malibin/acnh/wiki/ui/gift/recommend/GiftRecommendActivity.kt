package com.malibin.acnh.wiki.ui.gift.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.ActivityGiftRecommendBinding
import com.malibin.acnh.wiki.ui.gift.PickGiftActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GiftRecommendActivity : AppCompatActivity() {

    private val giftRecommendViewModel: GiftRecommendViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        giftRecommendViewModel.setVillager(getVillagerAmiiboIndex())

        val binding = ActivityGiftRecommendBinding.inflate(layoutInflater)
        initView(binding)
        setContentView(binding.root)
    }

    private fun initView(binding: ActivityGiftRecommendBinding) {
        binding.viewModel = giftRecommendViewModel
        binding.lifecycleOwner = this
        binding.btnBack.setOnClickListener { finish() }
        binding.btnItemSelect.setOnClickListener { deployPickGiftActivity() }
    }

    private fun getVillagerAmiiboIndex(): Int {
        return intent.getIntExtra(AMIIBO_INDEX, Villager.ERROR_AMIIBO_INDEX)
    }

    private fun deployPickGiftActivity() {
        val intent = Intent(this, PickGiftActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val AMIIBO_INDEX = "amiiboIndex"
    }
}
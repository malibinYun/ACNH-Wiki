package com.malibin.acnh.wiki.ui.gift.recommend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.acnh.wiki.databinding.ActivityGiftRecommendBinding

class GiftRecommendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityGiftRecommendBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
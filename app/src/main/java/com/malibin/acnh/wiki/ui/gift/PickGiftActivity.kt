package com.malibin.acnh.wiki.ui.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.acnh.wiki.databinding.ActivityPickGiftBinding

class PickGiftActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPickGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
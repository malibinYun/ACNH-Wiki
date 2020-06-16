package com.malibin.acnh.wiki.ui.villager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.acnh.wiki.databinding.ActivityVillagersBinding

class VillagersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
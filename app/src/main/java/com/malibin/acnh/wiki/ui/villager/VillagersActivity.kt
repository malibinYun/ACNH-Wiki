package com.malibin.acnh.wiki.ui.villager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.ActivityVillagersBinding

class VillagersActivity : AppCompatActivity(), VillagerClickListener {

    private lateinit var villagersAdapter: VillagersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView(binding)
    }

    private fun initView(binding: ActivityVillagersBinding) {
        villagersAdapter = VillagersAdapter()
        villagersAdapter.setVillagerClickListener(this)
        binding.rvVillagers.adapter = villagersAdapter
    }


    override fun onVillagerClick(villager: Villager) {

    }
}
package com.malibin.acnh.wiki.ui.villager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.ActivityVillagersBinding
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity.Companion.AMIIBO_INDEX
import org.koin.androidx.viewmodel.ext.android.viewModel

class VillagersActivity : AppCompatActivity(), VillagerClickListener {

    private lateinit var villagersAdapter: VillagersAdapter
    private val villagersViewModel: VillagersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView(binding)

        subscribeVillagers()
    }

    override fun onVillagerClick(villager: Villager) {
        val intent = Intent(this, VillagerDetailActivity::class.java)
        intent.putExtra(AMIIBO_INDEX, villager.amiiboIndex)
        startActivity(intent)
    }

    private fun initView(binding: ActivityVillagersBinding) {
        villagersAdapter = VillagersAdapter()
        villagersAdapter.setVillagerClickListener(this)
        binding.rvVillagers.adapter = villagersAdapter
    }

    private fun subscribeVillagers() {
        villagersViewModel.villagers.observe(this, Observer {
            villagersAdapter.submitList(it)
        })
    }
}
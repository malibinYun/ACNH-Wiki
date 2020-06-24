package com.malibin.acnh.wiki.ui.villager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.ActivityVillagersBinding
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity.Companion.AMIIBO_INDEX
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity.Companion.VILLAGER_STATE_CHANGED
import com.malibin.acnh.wiki.ui.villager.like.VillagerLikeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class VillagersActivity : AppCompatActivity(), VillagerClickListener {

    private lateinit var villagersAdapter: VillagersAdapter
    private val villagersViewModel: VillagersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagersBinding.inflate(layoutInflater)
        initView(binding)
        setContentView(binding.root)

        subscribeVillagers()
        villagersViewModel.loadAllVillagers()
    }

    override fun onClickVillager(villager: Villager) {
        val intent = Intent(this, VillagerDetailActivity::class.java)
        intent.putExtra(AMIIBO_INDEX, villager.amiiboIndex)
        startActivityForResult(intent, VillagerDetailActivity.REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == VillagerDetailActivity.REQUEST_CODE) {
            if (resultCode == VILLAGER_STATE_CHANGED) {
                villagersViewModel.loadAllVillagers()
            }
        }
    }

    private fun initView(binding: ActivityVillagersBinding) {
        binding.lifecycleOwner = this
        binding.viewModel = villagersViewModel
        villagersAdapter = VillagersAdapter()
        villagersAdapter.setVillagerClickListener(this)
        binding.rvVillagers.adapter = villagersAdapter
        binding.btnBack.setOnClickListener { finish() }
        binding.btnLikeVillagers.setOnClickListener { deployLikeVillagersActivity() }
    }

    private fun deployLikeVillagersActivity() {
        val intent = Intent(this, VillagerLikeActivity::class.java)
        startActivity(intent)
    }

    private fun subscribeVillagers() {
        villagersViewModel.villagers.observe(this, Observer {
            villagersAdapter.submitList(it)
        })
    }
}
package com.malibin.acnh.wiki.ui.villager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.malibin.acnh.wiki.data.AppDataBase
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.data.source.local.VillagersLocalDataSource
import com.malibin.acnh.wiki.data.source.remote.VillagersRemoteDataSource
import com.malibin.acnh.wiki.databinding.ActivityVillagersBinding
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity.Companion.AMIIBO_INDEX

class VillagersActivity : AppCompatActivity(), VillagerClickListener {

    private lateinit var villagersAdapter: VillagersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView(binding)

        val database = Room.databaseBuilder(this, AppDataBase::class.java, "db")
            .build()
        val viewModel = VillagersViewModel(
            VillagersRepository(
                VillagersLocalDataSource(database.villagersDao()),
                VillagersRemoteDataSource(FirebaseFirestore.getInstance())
            )
        )

        viewModel.villagers.observe(this, Observer {
            villagersAdapter.submitList(it)
        })
    }

    private fun initView(binding: ActivityVillagersBinding) {
        villagersAdapter = VillagersAdapter()
        villagersAdapter.setVillagerClickListener(this)
        binding.rvVillagers.adapter = villagersAdapter
    }

    override fun onVillagerClick(villager: Villager) {
        val intent = Intent(this, VillagerDetailActivity::class.java)
        intent.putExtra(AMIIBO_INDEX, villager.amiiboIndex)
        startActivity(intent)
    }
}
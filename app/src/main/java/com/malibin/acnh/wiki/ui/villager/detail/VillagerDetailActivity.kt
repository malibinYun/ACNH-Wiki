package com.malibin.acnh.wiki.ui.villager.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.malibin.acnh.wiki.data.AppDataBase
import com.malibin.acnh.wiki.data.repository.VillagersRepository
import com.malibin.acnh.wiki.data.source.local.VillagersLocalDataSource
import com.malibin.acnh.wiki.data.source.remote.VillagersRemoteDataSource
import com.malibin.acnh.wiki.databinding.ActivityVillagerDetailBinding

class VillagerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Room.databaseBuilder(this, AppDataBase::class.java, "db")
            .build()
        val viewModel = VillagerDetailViewModel(
            VillagersRepository(
                VillagersLocalDataSource(database.villagersDao()),
                VillagersRemoteDataSource(FirebaseFirestore.getInstance())
            )
        )

        binding.villagerViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.loadVillagerOf(getAmiiboIndex())

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
package com.malibin.acnh.wiki.ui.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.ActivityPickGiftBinding
import com.malibin.acnh.wiki.ui.utils.addFragmentToActivity
import com.malibin.acnh.wiki.ui.utils.replaceFragmentInActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PickGiftActivity : AppCompatActivity() {

    private val pickGiftViewModel: PickGiftViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPickGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragmentInActivity(PickGiftFragment(), R.id.fragment_container)

        subscribePickedItemType()
    }

    private fun subscribePickedItemType() {
        pickGiftViewModel.pickedItemType.observe(this, Observer {
            addFragmentToActivity(ItemsFragment(), R.id.fragment_container)
        })
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
        supportFragmentManager.popBackStack()
    }
}
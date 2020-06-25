package com.malibin.acnh.wiki.ui.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.ActivityPickGiftBinding
import com.malibin.acnh.wiki.ui.gift.detail.GiftDetailFragment
import com.malibin.acnh.wiki.ui.utils.addFragmentToActivity
import com.malibin.acnh.wiki.ui.utils.replaceFragmentInActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PickGiftActivity : AppCompatActivity() {

    private val pickGiftViewModel: PickGiftViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPickGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragmentInActivity(GiftCategoryFragment(), CONTAINER_ID)

        subscribePickedItemType()
        subscribePickedItem()
    }

    private fun subscribePickedItemType() {
        pickGiftViewModel.pickedItemType.observe(this, Observer {
            addFragmentToActivity(GiftsFragment(), CONTAINER_ID)
        })
    }

    private fun subscribePickedItem() {
        pickGiftViewModel.pickedItemVariations.observe(this, Observer {
            addFragmentToActivity(GiftDetailFragment(), CONTAINER_ID)
        })
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
        supportFragmentManager.popBackStack()
    }

    companion object {
        private const val CONTAINER_ID = R.id.fragment_container
    }
}
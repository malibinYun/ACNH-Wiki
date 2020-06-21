package com.malibin.acnh.wiki.ui.gift.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.data.entity.Wearable.Companion.WEARABLE_LIST
import com.malibin.acnh.wiki.databinding.FragmentGiftDetailBinding
import com.malibin.acnh.wiki.ui.gift.ItemClickListener
import com.malibin.acnh.wiki.ui.gift.PickGiftViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created By Malibin
 * on 6월 22, 2020
 */

class GiftDetailFragment : Fragment(), ItemClickListener {

    private val pickGiftViewModel: PickGiftViewModel by sharedViewModel()
    private lateinit var giftDetailAdapter: GiftDetailAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        giftDetailAdapter = GiftDetailAdapter()
        giftDetailAdapter.setItemClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (WEARABLE_LIST.contains(pickGiftViewModel.pickedItemType.value)) {
            val binding = FragmentGiftDetailBinding.inflate(inflater)
            binding.lifecycleOwner = this
            binding.viewModel = pickGiftViewModel
            binding.rvVariations.adapter = giftDetailAdapter
            return binding.root
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribePickedItems()
    }

    private fun subscribePickedItems() {
        pickGiftViewModel.pickedItemVariations.observe(this, Observer {
            Log.d("Malibin", it.toString())
            giftDetailAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        giftDetailAdapter.clearList()
    }

    override fun onItemClick(item: Item) {
        pickGiftViewModel.pickVariationOfItem(item)
    }
}
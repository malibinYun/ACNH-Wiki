package com.malibin.acnh.wiki.ui.gift

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.databinding.FragmentItemsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

class ItemsFragment : Fragment(), ItemClickListener {

    private val pickGiftViewModel: PickGiftViewModel by sharedViewModel()
    private lateinit var itemsAdapter: ItemsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        itemsAdapter = ItemsAdapter()
        itemsAdapter.setItemClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentItemsBinding.inflate(inflater)
        binding.rvItems.adapter = itemsAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeItemsOfPickedType()
    }

    private fun subscribeItemsOfPickedType() {
        pickGiftViewModel.itemsOfPickedType.observe(this, Observer {
            itemsAdapter.submitList(it)
        })
    }

    override fun onItemClick(item: Item) {
        pickGiftViewModel.pickItem(item)
    }

}
package com.malibin.acnh.wiki.ui.gift.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.databinding.ItemItemVariationBinding
import com.malibin.acnh.wiki.ui.gift.ItemClickListener

/**
 * Created By Malibin
 * on 6월 22, 2020
 */

class GiftDetailAdapter : RecyclerView.Adapter<GiftDetailAdapter.ViewHolder>() {

    private val items = mutableListOf<Item>()
    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemItemVariationBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun setItemClickListener(listener: ItemClickListener?) {
        this.itemClickListener = listener
    }

    fun submitList(items: List<Item>) {
        clearList()
        this.items.addAll(items)
        notifyItemRangeInserted(0, items.size)
    }

    fun clearList() {
        notifyItemRangeRemoved(0, items.size)
        items.clear()
    }

    inner class ViewHolder(
        private val binding: ItemItemVariationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.item = item
            binding.clickListener = itemClickListener
        }
    }
}
package com.malibin.acnh.wiki.ui.gift

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.databinding.ItemGameItemBinding

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

class ItemsAdapter : ListAdapter<Item, ItemsAdapter.ViewHolder>(DiffItemCallback()) {

    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setItemClickListener(listener: ItemClickListener?) {
        this.itemClickListener = listener
    }

    inner class ViewHolder(
        private val binding: ItemGameItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.item = item
            binding.clickListener = itemClickListener
        }
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}
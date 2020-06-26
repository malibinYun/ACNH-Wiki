package com.malibin.acnh.wiki.ui.villager.furniture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.databinding.ItemFurnitureSimpleInfoBinding

/**
 * Created By Malibin
 * on 6월 26, 2020
 */

class VillagerFurnitureAdapter : RecyclerView.Adapter<VillagerFurnitureAdapter.ViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFurnitureSimpleInfoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun submitList(items: List<Item>) {
        clearItems()
        this.items.addAll(items)
        notifyItemRangeInserted(0, itemCount)
    }

    fun clearItems() {
        notifyItemRangeRemoved(0, itemCount)
        items.clear()
    }

    inner class ViewHolder(
        private val binding: ItemFurnitureSimpleInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.item = item
        }
    }
}
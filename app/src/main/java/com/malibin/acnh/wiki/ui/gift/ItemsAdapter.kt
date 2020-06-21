package com.malibin.acnh.wiki.ui.gift

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malibin.acnh.wiki.data.Item
import com.malibin.acnh.wiki.databinding.ItemGameItemBinding

/**
 * Created By Malibin
 * on 6월 21, 2020
 */

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private lateinit var items: List<Item>
    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun submitList(items: List<Item>) {
        this.items = items
        notifyItemChanged(0, items.size)
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
}
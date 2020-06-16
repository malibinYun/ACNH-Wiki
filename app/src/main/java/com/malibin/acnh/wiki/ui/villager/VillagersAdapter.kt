package com.malibin.acnh.wiki.ui.villager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.ItemVillagerBinding

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

class VillagersAdapter : ListAdapter<Villager, VillagersAdapter.ViewHolder>(DiffItemCallback()) {

    private var villagerClickListener: VillagerClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVillagerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val villager = getItem(position)
        holder.bind(villager)
    }

    fun setVillagerClickListener(villagerClickListener: VillagerClickListener?) {
        this.villagerClickListener = villagerClickListener
    }

    inner class ViewHolder(
        private val binding: ItemVillagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(villager: Villager) {
            binding.villager = villager
            binding.villagerClickListener = villagerClickListener
        }
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<Villager>() {
        override fun areItemsTheSame(oldItem: Villager, newItem: Villager): Boolean {
            return oldItem.amiiboIndex == newItem.amiiboIndex
        }

        override fun areContentsTheSame(oldItem: Villager, newItem: Villager): Boolean {
            return oldItem == newItem
        }
    }
}
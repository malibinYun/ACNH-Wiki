package com.malibin.acnh.wiki.ui.villager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.databinding.FragmentVillagersBinding
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created By Malibin
 * on 6월 24, 2020
 */

class VillagersFragment : Fragment(), VillagerClickListener {

    private val villagersViewModel: VillagersViewModel by viewModel()
    private val villagersAdapter = VillagersAdapter()
    private lateinit var villagersLoadingStrategy: VillagersLoadingStrategy

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVillagersBinding.inflate(inflater, container, false)
        initView(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeVillagers()
        villagersLoadingStrategy.loadVillagers(villagersViewModel)
    }

    override fun onClickVillager(villager: Villager) {
        val intent = Intent(activity, VillagerDetailActivity::class.java)
        intent.putExtra(VillagerDetailActivity.AMIIBO_INDEX, villager.amiiboIndex)
        activity?.startActivityForResult(intent, VillagerDetailActivity.REQUEST_CODE)
    }

    private fun initView(binding: FragmentVillagersBinding) {
        binding.lifecycleOwner = this
        binding.viewModel = villagersViewModel
        binding.rvVillagers.adapter = villagersAdapter
        villagersAdapter.setVillagerClickListener(this)
    }

    private fun subscribeVillagers() {
        villagersViewModel.villagers.observe(this, Observer {
            villagersAdapter.submitList(it)
        })
    }

    fun refreshVillagers(){
        villagersLoadingStrategy.loadVillagers(villagersViewModel)
    }

    companion object {
        fun getInstance(loadingStrategy: VillagersLoadingStrategy) = VillagersFragment()
            .apply { villagersLoadingStrategy = loadingStrategy }
    }
}
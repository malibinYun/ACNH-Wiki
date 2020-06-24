package com.malibin.acnh.wiki.ui.villager.like

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created By Malibin
 * on 6월 24, 2020
 */

class VillagerLikeViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val favoriteVillagersFragment = VillagersFragment()
    private val homeVillagersFragment = VillagersFragment()

    override fun getItem(position: Int): Fragment = when (position) {
        FRAGMENT_FAVORITE -> favoriteVillagersFragment
        FRAGMENT_IN_HOME -> homeVillagersFragment
        else -> throw IllegalArgumentException("position $position cannot exist")
    }

    override fun getCount(): Int = PAGE_SIZE

    companion object {
        const val PAGE_SIZE = 2
        const val FRAGMENT_FAVORITE = 0
        const val FRAGMENT_IN_HOME = 1
    }
}
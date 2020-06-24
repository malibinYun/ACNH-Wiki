package com.malibin.acnh.wiki.ui.villager.like

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.ActivityVillagerLikeBinding
import com.malibin.acnh.wiki.ui.utils.changeStatusBarColor

class VillagerLikeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagerLikeBinding.inflate(layoutInflater)
        initView(binding)
        setContentView(binding.root)
    }

    private fun initView(binding: ActivityVillagerLikeBinding) {
        changeStatusBarColor(R.color.white)
        binding.vpVillagerLikes.adapter = VillagerLikeViewPagerAdapter(supportFragmentManager)
        binding.vpVillagerLikes.addOnPageChangeListener(binding.indicatorTab as ViewPager.OnPageChangeListener)
        binding.tab.setupWithViewPager(binding.vpVillagerLikes)
        bindTabIcons(binding.tab)
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun bindTabIcons(tab: TabLayout) {
        tab.getTabAt(0)?.setIcon(R.drawable.favorite_ic)
        tab.getTabAt(1)?.setIcon(R.drawable.in_home_ic)
    }
}




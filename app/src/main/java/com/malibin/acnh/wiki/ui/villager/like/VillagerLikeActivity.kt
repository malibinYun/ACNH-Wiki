package com.malibin.acnh.wiki.ui.villager.like

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.malibin.acnh.wiki.R
import com.malibin.acnh.wiki.databinding.ActivityVillagerLikeBinding
import com.malibin.acnh.wiki.ui.utils.changeStatusBarColor
import com.malibin.acnh.wiki.ui.villager.detail.VillagerDetailActivity

class VillagerLikeActivity : AppCompatActivity() {

    private val pagerAdapter = VillagerLikeViewPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityVillagerLikeBinding.inflate(layoutInflater)
        initView(binding)
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == VillagerDetailActivity.REQUEST_CODE) {
            if (resultCode == VillagerDetailActivity.VILLAGER_STATE_CHANGED) {
                pagerAdapter.refreshVillagers()
            }
        }
    }

    private fun initView(binding: ActivityVillagerLikeBinding) {
        changeStatusBarColor(R.color.white)
        binding.vpVillagerLikes.adapter = pagerAdapter
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




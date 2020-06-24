package com.malibin.acnh.wiki.ui.villager.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.malibin.acnh.wiki.R

/**
 * Created By Malibin
 * on 6월 24, 2020
 */

class VillagersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_villagers, container, false)
    }
}
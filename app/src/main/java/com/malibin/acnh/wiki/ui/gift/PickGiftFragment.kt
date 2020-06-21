package com.malibin.acnh.wiki.ui.gift

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.malibin.acnh.wiki.databinding.FragmentPickGiftBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created By Malibin
 * on 6월 20, 2020
 */

class PickGiftFragment : Fragment() {

    private val pickGiftViewModel: PickGiftViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPickGiftBinding.inflate(layoutInflater, container, false)
        binding.viewModel = pickGiftViewModel
        return binding.root
    }

}
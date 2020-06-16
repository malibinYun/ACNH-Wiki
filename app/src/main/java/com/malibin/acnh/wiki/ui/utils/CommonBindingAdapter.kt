package com.malibin.acnh.wiki.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

@BindingAdapter("imageUrl")
fun bindingImageUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
        .into(view)
}
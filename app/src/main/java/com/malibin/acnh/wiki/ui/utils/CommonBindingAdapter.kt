package com.malibin.acnh.wiki.ui.utils

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.malibin.acnh.wiki.R

/**
 * Created By Malibin
 * on 6월 16, 2020
 */

@BindingAdapter("imageUrl")
fun bindingImageUrl(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
        .placeholder(R.drawable.loading)
        .into(view)
}

@BindingAdapter("textList")
fun bindingTextList(view: TextView, texts: List<String>?) {
    if (texts == null) return
    view.text = TextUtils.join(", ", texts)
}

@BindingAdapter("enabled")
fun bindingEnabled(view: View, isEnable: Boolean?) {
    view.isEnabled = isEnable ?: false
}
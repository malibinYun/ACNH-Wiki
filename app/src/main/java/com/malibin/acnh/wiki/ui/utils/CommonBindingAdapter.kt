package com.malibin.acnh.wiki.ui.utils

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.malibin.acnh.wiki.R
import kotlin.math.roundToInt

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

@BindingAdapter("selected")
fun bindingSelected(view: View, isSelected: Boolean?) {
    view.isSelected = isSelected ?: false
}

@BindingAdapter("layout_marginTop")
fun bindingLayoutMarginTop(view: View, margin: Float) {
    val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
    layoutParams.setMargins(
        layoutParams.leftMargin,
        margin.roundToInt(),
        layoutParams.rightMargin,
        layoutParams.bottomMargin
    )
    view.layoutParams = layoutParams
}

//@BindingAdapter("android:layout_marginBottom")
//public static void setBottomMargin(View view, float bottomMargin) {
//    MarginLayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();
//    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,
//        layoutParams.rightMargin, Math.round(bottomMargin));
//    view.setLayoutParams(layoutParams);
//}
package com.malibin.acnh.wiki.ui.villager

import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.ui.utils.toDp
import com.malibin.acnh.wiki.ui.utils.toPx
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Malibin
 * on 6월 17, 2020
 */

@BindingAdapter("birthdayText")
fun bindingBirthday(textView: TextView, date: Date?) {
    if (date == null) return
    val dateFormat = SimpleDateFormat("MM월 dd일", Locale.KOREA)
    textView.text = dateFormat.format(date)
}

@BindingAdapter("stylesText")
fun bindingStyles(textView: TextView, styles: List<String>?) {
    if (styles == null) return
    textView.text = TextUtils.join(" / ", styles)
}

@BindingAdapter("amiiboCard")
fun bindingAmiiboCard(imageView: ImageView, villager: Villager?) {
    if (villager == null) return
    val params = imageView.layoutParams
    if (villager.amiiboIndex in 401..450) {
        params.height = 220.toPx()
        imageView.layoutParams = params
    } else {
        params.height = 440.toPx()
        imageView.layoutParams = params
    }
    Glide.with(imageView)
        .load(villager.amiiboCardUrl)
        .into(imageView)
}
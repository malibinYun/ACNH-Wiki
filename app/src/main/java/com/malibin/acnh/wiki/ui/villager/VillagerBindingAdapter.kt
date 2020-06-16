package com.malibin.acnh.wiki.ui.villager

import android.text.TextUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter
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
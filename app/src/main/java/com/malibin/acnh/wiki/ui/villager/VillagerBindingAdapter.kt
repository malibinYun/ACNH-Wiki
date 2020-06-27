package com.malibin.acnh.wiki.ui.villager

import android.os.Build
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.malibin.acnh.wiki.data.FavoriteColor
import com.malibin.acnh.wiki.data.entity.Villager
import com.malibin.acnh.wiki.ui.utils.toDp
import com.malibin.acnh.wiki.ui.utils.toPx
import io.opencensus.resource.Resource
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

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("favoriteColorFirst")
fun bindingFavoriteColorFirst(imageView: ImageView, favoriteColors: List<FavoriteColor>) {
//    imageView.setBackgroundResource(favoriteColors[0].colorRes)
    imageView.setColorFilter(
        imageView.context.resources.getColor(favoriteColors[0].colorRes, null),
        android.graphics.PorterDuff.Mode.MULTIPLY
    )
}

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("favoriteColorSecond")
fun bindingFavoriteColorSecond(imageView: ImageView, favoriteColors: List<FavoriteColor>) {
    try {
//        imageView.setBackgroundResource(favoriteColors[1].colorRes)
        imageView.setColorFilter(
            imageView.context.resources.getColor(favoriteColors[1].colorRes, null),
            android.graphics.PorterDuff.Mode.MULTIPLY
        )

    } catch (e: Exception) {
        imageView.visibility = View.GONE
    }

}
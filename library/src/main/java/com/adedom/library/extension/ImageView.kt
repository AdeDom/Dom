package com.adedom.library.extension

import android.widget.ImageView
import com.adedom.library.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//ivImage.loadCircle("$BASE_URL../profiles/$image")
fun ImageView.loadCircle(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_user_black))
        .circleCrop()
        .into(this)
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_image_black))
        .into(this)
}


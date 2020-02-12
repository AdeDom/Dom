package com.adedom.library.extension

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.adedom.library.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

//ivImage.loadCircle("$BASE_URL../profiles/$image")
fun ImageView.loadCircle(url: String) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_user_black))
        .circleCrop()
        .into(this)
}

fun ImageView.loadCircle(bitmap: Bitmap?) {
    Glide.with(this)
        .load(bitmap)
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

fun ImageView.loadBitmap(
    url: String,
    onResourceReady: (Bitmap) -> Unit,
    onLoadCleared: (() -> Unit)? = null
) {
    Glide.with(this)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) {
                onLoadCleared?.invoke()
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                onResourceReady.invoke(resource)
            }
        })
}

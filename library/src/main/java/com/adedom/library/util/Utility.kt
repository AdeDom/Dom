package com.adedom.library.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

//loadBitmap(context, url, { onResourceReady }, { onLoadCleared })
fun loadBitmap(
    context: Context,
    url: String,
    onResourceReady: (Bitmap) -> Unit,
    onLoadCleared: (() -> Unit)? = null
) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .circleCrop()
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                onResourceReady.invoke(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                onLoadCleared?.invoke()
            }
        })
}
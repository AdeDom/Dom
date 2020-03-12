package com.adedom.library.extension

import android.view.animation.Animation

fun Animation.onAnimationEnd(onAnimationEnd: () -> Unit) {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {
            onAnimationEnd.invoke()
        }

        override fun onAnimationStart(animation: Animation?) {}
    })
}
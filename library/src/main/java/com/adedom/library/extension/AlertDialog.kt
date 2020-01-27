package com.adedom.library.extension

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.adedom.library.R

//return AlertDialog.Builder(activity!!).dialogFragment(bView, R.drawable.ic_h2p, R.string.about)
fun AlertDialog.Builder.dialogFragment(view: View, icon: Int, title: Int) =
    this.setView(view).setIcon(icon).setTitle(title).create()

//AlertDialog.Builder(activity!!).dialogNegative(
//    R.string.title,
//    R.string.message,
//    R.drawable.ic_icon
//) { NegativeButton }
fun AlertDialog.Builder.dialogNegative(
    title: Int,
    message: Int,
    icon: Int,
    negative: () -> Unit
) {
    this.setTitle(title)
        .setMessage(message)
        .setIcon(icon)
        .setPositiveButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .setNegativeButton(R.string.yes) { dialog, which ->
            negative.invoke()
        }.show()
}

fun AlertDialog.Builder.dialogNegative(
    title: Int,
    message: String,
    icon: Int,
    negative: () -> Unit
) {
    this.setTitle(title)
        .setMessage(message)
        .setIcon(icon)
        .setPositiveButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .setNegativeButton(R.string.yes) { dialog, which ->
            negative.invoke()
        }.show()
}

fun AlertDialog.Builder.dialogNegative(
    title: Int,
    negative: () -> Unit
) {
    this.setTitle(title)
        .setPositiveButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .setNegativeButton(R.string.yes) { dialog, which ->
            negative.invoke()
        }.show()
}

fun AlertDialog.Builder.dialogPositive(
    title: Int,
    message: Int,
    icon: Int,
    positive: () -> Unit
) {
    this.setTitle(title)
        .setMessage(message)
        .setIcon(icon)
        .setPositiveButton(R.string.yes) { dialog, which -> positive.invoke() }
        .setNegativeButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .show()
}

fun AlertDialog.Builder.dialogPositive(
    title: Int,
    message: String,
    icon: Int,
    positive: () -> Unit
) {
    this.setTitle(title)
        .setMessage(message)
        .setIcon(icon)
        .setPositiveButton(R.string.yes) { dialog, which -> positive.invoke() }
        .setNegativeButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .show()
}

fun AlertDialog.Builder.dialogPositive(
    title: Int,
    positive: () -> Unit
) {
    this.setTitle(title)
        .setPositiveButton(R.string.yes) { dialog, which -> positive.invoke() }
        .setNegativeButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .show()
}

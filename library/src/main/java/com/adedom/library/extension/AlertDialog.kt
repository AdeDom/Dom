package com.adedom.library.extension

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.adedom.library.R

//return AlertDialog.Builder(activity!!).dialogFragment(bView, R.drawable.ic_h2p, R.string.about)
fun AlertDialog.Builder.dialogFragment(view: View, icon: Int, title: Int) =
    this.setView(view).setIcon(icon).setTitle(title).create()

//AlertDialog.Builder(activity!!).dialogNegative(
//    R.string.exit,
//    R.drawable.ic_exit_black
//) { GameActivity.sActivity.finishAffinity() }
fun AlertDialog.Builder.dialogNegative(title: Int, icon: Int, negative: () -> Unit) {
    this.setTitle(title)
        .setIcon(icon)
        .setPositiveButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .setNegativeButton(R.string.yes) { dialog, which ->
            negative.invoke()
        }.show()
}

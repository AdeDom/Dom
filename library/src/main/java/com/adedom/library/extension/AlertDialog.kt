package com.adedom.library.extension

import android.view.View
import androidx.appcompat.app.AlertDialog
import com.adedom.library.R

//return AlertDialog.Builder(activity!!).dialogFragment(bView, R.drawable.ic_h2p, R.string.about)
fun AlertDialog.Builder.dialogFragment(view: View, icon: Int, title: Int) =
    this.setView(view).setIcon(icon).setTitle(title).create()

//AlertDialog.Builder(activity!!).dialogExit { GameActivity.sActivity.finishAffinity() }
fun AlertDialog.Builder.dialogExit(negative: () -> Unit) {
    this.setIcon(R.drawable.ic_exit_black)
        .setTitle(R.string.exit)
        .setPositiveButton(R.string.no) { dialog, which -> dialog.dismiss() }
        .setNegativeButton(R.string.yes) { dialog, which ->
            negative.invoke()
        }.show()
}
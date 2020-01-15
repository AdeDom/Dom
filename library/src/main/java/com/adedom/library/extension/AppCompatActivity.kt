package com.adedom.library.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

//this.setToolbar(toolbar, getString(R.string.single_player), true)
fun AppCompatActivity.setToolbar(toolbar: Toolbar, title: String, onBack: Boolean = false) {
    toolbar.title = title
    setSupportActionBar(toolbar)
    supportActionBar!!.setDisplayHomeAsUpEnabled(onBack)
}
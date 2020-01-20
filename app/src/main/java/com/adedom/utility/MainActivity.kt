package com.adedom.utility

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adedom.library.util.playSound

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun soundButton(view: View) {
        playSound(baseContext, R.raw.sound_bt)
    }

    fun soundKeep(view: View) {
        playSound(baseContext, R.raw.sound_keep)
    }

}


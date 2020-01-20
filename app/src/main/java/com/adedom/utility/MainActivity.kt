package com.adedom.utility

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adedom.library.util.pauseMusic
import com.adedom.library.util.playMusic
import com.adedom.library.util.stopMusic


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        playMusic(baseContext, R.raw.music)
    }

    fun pause(view: View) {
        pauseMusic()
    }

    fun stop(view: View) {
        stopMusic()
    }

    fun main2(view: View) {
        startActivity(Intent(baseContext, Main2Activity::class.java))
    }
}

package com.adedom.utility

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adedom.library.util.pauseMusic
import com.adedom.library.util.playMusic
import com.adedom.library.util.stopMusic

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun start(view: View) {
        playMusic(baseContext,R.raw.music)
    }

    fun pause(view: View) {
        pauseMusic()
    }

    fun stop(view: View) {
        stopMusic()
    }

}

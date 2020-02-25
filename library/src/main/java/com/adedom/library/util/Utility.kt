package com.adedom.library.util

import android.content.Context
import android.media.MediaPlayer
import java.text.SimpleDateFormat
import java.util.*

//getDateTime(KEY_DATE)
fun getDateTime(keyDateTime: String): String =
    SimpleDateFormat(keyDateTime, Locale.getDefault()).format(System.currentTimeMillis())

fun getKeyUUID(): String = UUID.randomUUID().toString().replace("-", "")

var mediaPlayerMusic: MediaPlayer? = null
//playMusic(baseContext, R.raw.music)
fun playMusic(context: Context, music: Int) {
    if (mediaPlayerMusic == null)
        mediaPlayerMusic = MediaPlayer.create(context, music)

    mediaPlayerMusic.apply {
        this!!.start()
        isLooping = true
    }
}

//pauseMusic()
fun pauseMusic() {
    if (mediaPlayerMusic != null)
        mediaPlayerMusic!!.pause()
}

//stopMusic()
fun stopMusic() {
    if (mediaPlayerMusic != null) {
        mediaPlayerMusic!!.stop()
        mediaPlayerMusic = null
    }
}

//playSound(baseContext, R.raw.sound)
fun playSound(context: Context, music: Int) = MediaPlayer.create(context, music).start()


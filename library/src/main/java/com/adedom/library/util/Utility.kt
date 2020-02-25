package com.adedom.library.util

import android.content.Context
import android.location.Location
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

fun distanceBetween(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Float {
    val distance = FloatArray(1)
    Location.distanceBetween(lat1, lng1, lat2, lng2, distance)
    return distance[0]
}
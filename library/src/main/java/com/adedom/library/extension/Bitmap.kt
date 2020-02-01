package com.adedom.library.extension

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Bitmap.imageToString(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
    val imgByte = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(imgByte, Base64.DEFAULT)
}

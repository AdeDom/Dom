package com.adedom.library.util

import java.text.SimpleDateFormat
import java.util.*

fun getDateTime(keyDateTime: String): String =
    SimpleDateFormat(keyDateTime, Locale.ENGLISH).format(Calendar.getInstance().time)


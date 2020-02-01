package com.adedom.library.extension

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Handler
import android.text.format.DateFormat
import com.adedom.library.R
import java.util.*

var countExit = 0
//this.exitApplication()
fun Activity.exitApplication() {
    if (countExit > 0) this.finishAffinity()
    countExit++
    Handler().postDelayed({ countExit = 0 }, 2000)
    baseContext.toast(R.string.finish_affinity)
}

//activity!!.dialogDatePicker { year, month, dayOfMonth -> }
fun Activity.dialogDatePicker(date: (Int, Int, Int) -> Unit) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val dpd = DatePickerDialog(
        this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            date.invoke(year, month + 1, dayOfMonth)
        },
        year,
        month,
        day
    )
    dpd.show()
}

//activity!!.dialogTimePicker { hourOfDay, minute -> }
fun Activity.dialogTimePicker(time: (Int, Int) -> Unit) {
    val c = Calendar.getInstance()
    val hour = c.get(Calendar.HOUR_OF_DAY)
    val minute = c.get(Calendar.MINUTE)

    val t = TimePickerDialog(
        this,
        TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minute ->
            time.invoke(hourOfDay, minute)
        },
        hour,
        minute,
        DateFormat.is24HourFormat(this)
    )
    t.show()
}

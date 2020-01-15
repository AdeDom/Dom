package com.adedom.library.extension

import android.app.Activity
import android.os.Handler
import com.adedom.library.R

var countExit = 0
//this.exitApplication()
fun Activity.exitApplication() {
    if (countExit > 0) this.finishAffinity()
    countExit++
    Handler().postDelayed({ countExit = 0 }, 2000)
    baseContext.toast(R.string.finish_affinity)
}

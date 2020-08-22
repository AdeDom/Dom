package com.adedom.utility

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adedom.library.extension.dialogDatePicker
import com.adedom.library.extension.dialogTimePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtDate.setOnClickListener {
            this.dialogDatePicker { year, month, dayOfMonth ->
                mTvDate.text = "$year/$month/$dayOfMonth"
            }
        }

        mBtTime.setOnClickListener {
            this.dialogTimePicker { hourOfDay, minute ->
                mTvTime.text = "$hourOfDay:$minute"
            }
        }

    }

}


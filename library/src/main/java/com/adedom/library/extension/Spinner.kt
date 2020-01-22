package com.adedom.library.extension

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

//spinner.setSpinner<CountryItem>({ it.adapter = adapter }, { it.xxx })
fun <E>Spinner.setSpinner(adapter: (Spinner) -> Unit, item: (E) -> Unit) {
    this.apply { adapter.invoke(this) }
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {}

        override fun onItemSelected(
            parent: AdapterView<*>,
            view: View?,
            position: Int,
            id: Long
        ) {
            val model = parent.getItemAtPosition(position) as E
            item.invoke(model)
        }

    }
}

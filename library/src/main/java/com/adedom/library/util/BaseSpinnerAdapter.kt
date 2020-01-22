package com.adedom.library.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

//class ModelAdapter(
//    context: Context,
//    items: ArrayList<Model>,
//    layout: (() -> Int)? = null,
//    bindView: ((View, item) -> Unit)? = null,
//    resource: Int = 0
//) : BaseSpinnerAdapter<Model>(context, items,
//    { layout.run { R.layout.spinner } }, { view, item ->
//        bindView.apply {
//
//        }
//    }, resource
//)
abstract class BaseSpinnerAdapter<E>(
    context: Context,
    items: ArrayList<E>,
    private val layout: () -> Int,
    private val bindView: (View, E) -> Unit,
    resource: Int
) : ArrayAdapter<E>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null)
            view = LayoutInflater.from(context).inflate(layout.invoke(), parent, false)

        bindView.invoke(view!!, getItem(position)!!)

        return view
    }
}

package com.adedom.library.util

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.adedom.library.extension.dialogFragment

abstract class BaseDialogFragment<VM : ViewModel>(
    private val resource: () -> Int,
    private val icon: () -> Int,
    private val title: () -> Int
) : DialogFragment() {

    lateinit var viewModel: VM
    lateinit var v: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        v = activity!!.layoutInflater.inflate(resource.invoke(), null)

        initDialog(v)

        return AlertDialog.Builder(activity!!).dialogFragment(v, icon.invoke(), title.invoke())
    }

    open fun initDialog(view: View) {}

}

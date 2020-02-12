package com.adedom.library.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VM : ViewModel>(
    private val recource: () -> Int
) : Fragment() {

    lateinit var viewModel: VM
    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        v = inflater.inflate(recource.invoke(), container, false)

        initFragment(v)

        return v
    }

    open fun initFragment(view: View) {}

}

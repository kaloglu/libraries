package com.kaloglu.library.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment @ContentView constructor(
    @LayoutRes internal val resourceLayoutId: Int = 0
) : Fragment(resourceLayoutId) {
    internal lateinit var rootView: View

    val activity by lazy { getActivity() as BaseActivity }

    val fragmentTag = this.javaClass.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootView = view
        init(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
    }

    @CallSuper
    protected open fun init(savedInstanceState: Bundle?) = Unit

}

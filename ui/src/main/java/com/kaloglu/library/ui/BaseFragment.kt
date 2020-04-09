package com.kaloglu.library.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.kaloglu.library.ui.interfaces.ViewLifecycle

abstract class BaseFragment @ContentView constructor(
    @LayoutRes internal open val resourceLayoutId: Int = 0
) : Fragment(resourceLayoutId), ViewLifecycle {

    override lateinit var containerView: View

    override val activity by lazy { getActivity() as BaseActivity }
    override val application by lazy { activity.application }

    override val viewTag by lazy { this.javaClass.simpleName }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        containerView = view
        super.onViewCreated(view, savedInstanceState)
        initUserInterface(savedInstanceState)
    }

}

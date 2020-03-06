package com.kaloglu.library.ui.interfaces

import android.os.Bundle
import android.view.View
import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.BaseApplication

interface FragmentLifecycle {
    val application: BaseApplication
    val activity: BaseActivity
    val fragmentTag: String

    var fragmentView: View

    fun beforeOnCreate() = Unit

    fun initUserInterface(savedInstanceState: Bundle?)

}
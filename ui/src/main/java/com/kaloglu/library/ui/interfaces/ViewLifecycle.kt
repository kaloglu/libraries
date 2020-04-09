package com.kaloglu.library.ui.interfaces

import android.os.Bundle
import android.widget.Toast
import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.BaseApplication
import kotlinx.android.extensions.LayoutContainer

interface ViewLifecycle : LayoutContainer {
    val application: BaseApplication
    val activity: BaseActivity
    val fragmentTag: String

    fun initUserInterface(savedInstanceState: Bundle?)

    fun showToast(message: String) = Toast
        .makeText(
            (containerView?.context ?: application.applicationContext),
            this::class.java.simpleName + " : $message",
            Toast.LENGTH_SHORT
        )
        .show()

}
package com.kaloglu.library.ui.interfaces

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.BaseApplication

interface FragmentLifecycle {
    val application: BaseApplication
    val activity: BaseActivity
    val fragmentTag: String

    var fragmentView: View

    fun initUserInterface(savedInstanceState: Bundle?)

    fun showToast(message: String) = Toast
        .makeText(
            fragmentView.context,
            this::class.java.simpleName + " : $message",
            Toast.LENGTH_SHORT
        )
        .show()

}
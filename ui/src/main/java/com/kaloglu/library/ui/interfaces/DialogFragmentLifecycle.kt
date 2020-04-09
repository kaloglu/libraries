package com.kaloglu.library.ui.interfaces

import android.app.Dialog

interface DialogFragmentLifecycle : FragmentLifecycle {

    val dialogTitle: String?

    fun initUserInterface(dialog: Dialog) = Unit

}
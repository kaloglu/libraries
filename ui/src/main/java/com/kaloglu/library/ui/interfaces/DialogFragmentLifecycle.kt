package com.kaloglu.library.ui.interfaces

import android.app.Dialog

interface DialogFragmentLifecycle : ViewLifecycle {

    val dialogTitle: String?

    fun initUserInterface(dialog: Dialog) = Unit

}
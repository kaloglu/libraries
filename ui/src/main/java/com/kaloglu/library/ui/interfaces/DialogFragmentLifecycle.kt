package com.kaloglu.library.ui.interfaces

import android.app.Dialog
import android.view.Window

interface DialogFragmentLifecycle : ViewLifecycle {

    fun initUserInterface(dialog: Dialog) = Unit

    fun setDialogStyle(dialogWindow: Window)
}
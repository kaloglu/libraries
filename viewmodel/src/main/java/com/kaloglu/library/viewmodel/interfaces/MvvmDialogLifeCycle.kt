package com.kaloglu.library.viewmodel.interfaces

import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle
import com.kaloglu.library.viewmodel.BaseViewModel

interface MvvmDialogLifeCycle<VM> : MvvmLifeCycle<VM>,
    DialogFragmentLifecycle where VM : BaseViewModel<*, *>

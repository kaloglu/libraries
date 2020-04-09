package com.kaloglu.library.ui.viewmodel.interfaces

import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle
import com.kaloglu.library.ui.viewmodel.BaseViewModel

interface MvvmDialogLifeCycle<VM> : MvvmLifeCycle<VM>,
    DialogFragmentLifecycle where VM : BaseViewModel<*, *>

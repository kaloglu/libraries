package com.kaloglu.library.viewmodel.interfaces

import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.mvi.State

interface MvvmDialogLifeCycle<VM, S> : MvvmLifeCycle<VM, S>,
    DialogFragmentLifecycle where VM : BaseViewModel<*, S>, S : State

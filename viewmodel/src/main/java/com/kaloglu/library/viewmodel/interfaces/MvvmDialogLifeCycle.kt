package com.kaloglu.library.viewmodel.interfaces

import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
interface MvvmDialogLifeCycle<VM, E, S> : MvvmLifeCycle<VM, E, S>,
    DialogFragmentLifecycle where VM : BaseViewModel<E, S>, S : State, E : Event

package com.kaloglu.library.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class ViewModelActivity<VM, E, S> : BaseActivity(),
    MvvmLifeCycle<VM, E, S>
        where VM : BaseViewModel<E, S>, E : Event, S : State

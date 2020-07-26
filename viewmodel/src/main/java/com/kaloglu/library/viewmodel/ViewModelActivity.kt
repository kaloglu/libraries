package com.kaloglu.library.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class ViewModelActivity<VM, S> : BaseActivity(),
    MvvmLifeCycle<VM, S>
        where VM : BaseViewModel<*, S>, S : State

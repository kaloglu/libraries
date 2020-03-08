package com.kaloglu.library.ui.viewmodel.interfaces

import com.kaloglu.library.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
interface Mwwm<VM : BaseViewModel<*>> {
    val viewModel: VM
    fun onCreateViewModel()
    fun VM.observeViewModel()
}

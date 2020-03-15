package com.kaloglu.library.ui.viewmodel.interfaces

import com.kaloglu.library.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
interface Mwwm<VM : BaseViewModel<*, *>> {
    val viewModel: VM
    fun VM.observeViewModel()
}

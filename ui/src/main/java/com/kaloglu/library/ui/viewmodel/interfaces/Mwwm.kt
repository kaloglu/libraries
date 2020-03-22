package com.kaloglu.library.ui.viewmodel.interfaces

import com.kaloglu.library.ui.viewmodel.BaseViewModel

interface Mwwm<VM : BaseViewModel<*, *>> {
    val viewModel: VM
    fun VM.observeViewModel()
}

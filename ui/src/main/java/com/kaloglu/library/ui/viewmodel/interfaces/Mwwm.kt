package com.kaloglu.library.ui.viewmodel.interfaces

import com.kaloglu.library.ui.viewmodel.BaseViewModel

interface Mwwm<VM> where VM : BaseViewModel<*, *> {
    val viewModel: VM
    fun observeViewModel()
}

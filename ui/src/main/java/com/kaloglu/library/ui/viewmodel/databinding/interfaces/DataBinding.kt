package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.interfaces.MvvmLifeCycle

interface DataBinding<VDB, VM> : MvvmLifeCycle<VM>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, *> {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

package com.kaloglu.library.databinding4vm.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle

interface DataBinding<VDB, VM> :
    MvvmLifeCycle<VM>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, *> {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

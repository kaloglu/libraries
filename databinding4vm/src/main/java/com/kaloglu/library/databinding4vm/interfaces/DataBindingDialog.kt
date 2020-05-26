package com.kaloglu.library.databinding4vm.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmDialogLifeCycle

interface DataBindingDialog<VDB, VM> :
    MvvmDialogLifeCycle<VM>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, *> {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

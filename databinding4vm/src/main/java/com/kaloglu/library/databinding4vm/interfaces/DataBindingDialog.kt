package com.kaloglu.library.databinding4vm.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmDialogLifeCycle
import com.kaloglu.library.viewmodel.mvi.State

interface DataBindingDialog<VDB, VM, S> :
    MvvmDialogLifeCycle<VM, S>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, S>, S : State {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

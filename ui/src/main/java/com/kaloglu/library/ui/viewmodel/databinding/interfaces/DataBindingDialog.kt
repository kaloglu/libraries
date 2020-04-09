package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.databinding.BindableViewModel
import com.kaloglu.library.ui.viewmodel.interfaces.MvvmDialogLifeCycle

interface DataBindingDialog<VDB, VM> : MvvmDialogLifeCycle<VM>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, *> {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

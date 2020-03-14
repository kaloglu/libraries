package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import androidx.databinding.ViewDataBinding

interface DataBinding<VDB : ViewDataBinding> {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

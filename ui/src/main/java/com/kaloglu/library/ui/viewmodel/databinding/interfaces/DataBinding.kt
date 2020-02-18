package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

interface DataBinding<VDB : ViewDataBinding> {
    var viewDataBinding: VDB

    fun inflateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    fun getBindingVariable(): Int
    fun observeViewModel()
}

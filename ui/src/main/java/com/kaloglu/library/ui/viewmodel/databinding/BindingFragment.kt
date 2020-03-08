package com.kaloglu.library.ui.viewmodel.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.ViewModelFragment
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBinding

abstract class BindingFragment<VDB : ViewDataBinding, VM : BindableViewModel<*>>
@ContentView constructor(
    @LayoutRes override val resourceLayoutId: Int = 0
) : ViewModelFragment<VM>(), DataBinding<VDB> {

    override lateinit var viewDataBinding: VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflateViewBinding<VDB>(parent, resourceLayoutId) {
        setVariable(getBindingVariable(), viewModel)
        viewDataBinding = this
    }.root

}

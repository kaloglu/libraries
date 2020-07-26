package com.kaloglu.library.databinding4vm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.interfaces.DataBinding
import com.kaloglu.library.viewmodel.ViewModelFragment
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BindingFragment<VDB, VM, S> @ContentView
constructor(@LayoutRes override val resourceLayoutId: Int = 0) :
    ViewModelFragment<VM, S>(),
    DataBinding<VDB, VM, S>
        where VDB : ViewDataBinding, VM : BindableViewModel<*, S>, S : State {

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
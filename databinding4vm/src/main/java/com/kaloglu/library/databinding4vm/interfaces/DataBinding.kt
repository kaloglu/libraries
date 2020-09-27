package com.kaloglu.library.databinding4vm.interfaces

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.BindableViewModel
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
interface DataBinding<VDB, VM, E, S> :
    MvvmLifeCycle<VM, E, S>
        where VDB : ViewDataBinding, VM : BindableViewModel<E, S>, E : Event, S : State {
    var viewDataBinding: VDB

    fun getBindingVariable(): Int
}

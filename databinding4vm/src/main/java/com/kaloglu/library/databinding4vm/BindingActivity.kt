package com.kaloglu.library.databinding4vm

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.interfaces.DataBinding
import com.kaloglu.library.viewmodel.ViewModelActivity
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BindingActivity<VDB, VM, E, S> : ViewModelActivity<VM, E, S>(),
    DataBinding<VDB, VM, E, S>
        where VM : BindableViewModel<E, S>, E : Event, S : State, VDB : ViewDataBinding {

    internal open fun VDB.viewOnBind() = Unit

    override fun initUserInterface(savedInstanceState: Bundle?) {
        viewDataBinding = DataBindingUtil.setContentView(this, resourceLayoutId)
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
        viewDataBinding.viewOnBind()
    }

}

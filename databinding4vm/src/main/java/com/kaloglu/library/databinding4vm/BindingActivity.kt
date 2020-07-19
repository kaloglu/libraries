package com.kaloglu.library.databinding4vm

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.databinding4vm.interfaces.DataBinding
import com.kaloglu.library.viewmodel.ViewModelActivity
import com.kaloglu.library.viewmodel.mvi.State

abstract class BindingActivity<VDB, VM, S> : ViewModelActivity<VM, S>(),
    DataBinding<VDB, VM, S>
        where VM : BindableViewModel<*, S>, S : State, VDB : ViewDataBinding {

    internal open fun VDB.viewOnBind() = Unit

    override fun initUserInterface(savedInstanceState: Bundle?) {
        viewDataBinding = DataBindingUtil.setContentView(this, resourceLayoutId)
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
        viewDataBinding.viewOnBind()
    }

}

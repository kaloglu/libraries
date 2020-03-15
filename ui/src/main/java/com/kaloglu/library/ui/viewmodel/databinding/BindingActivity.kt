package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.ViewModelActivity
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class BindingActivity<VDB : ViewDataBinding, VM : BindableViewModel<*,*>>
    : ViewModelActivity<VM>(), DataBinding<VDB> {

    internal open fun VDB.viewOnBind() = Unit

    override fun initUserInterface() {
        viewDataBinding = DataBindingUtil.setContentView(this, resourceLayoutId)
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
        viewDataBinding.viewOnBind()
    }

}

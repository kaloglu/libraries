package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.BR
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.ViewModelActivity
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBinding

abstract class BindingActivity<VDB : ViewDataBinding, VM : BaseViewModel>
    : ViewModelActivity<VM>(), DataBinding<VDB> {
//    override val viewModel:BaseViewModel = getViewModel()

    abstract fun VDB.onBind()

    override fun getBindingVariable() = BR.dataModel

    override fun initUserInterface() {
        viewDataBinding = DataBindingUtil.setContentView(this, resourceLayoutId)
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
        viewDataBinding.onBind()
    }

}

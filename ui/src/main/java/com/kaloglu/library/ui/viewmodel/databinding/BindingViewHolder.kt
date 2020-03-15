package com.kaloglu.library.ui.viewmodel.databinding

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.BaseViewHolder
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBindingViewHolder
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class BindingViewHolder<RBVM : RecyclerBindableViewModel<*,*>>(private val binding: ViewDataBinding) :
    BaseViewHolder<RBVM>(binding.root), DataBindingViewHolder<RBVM> {

    @CallSuper
    override fun bindVariables(item: RBVM) {
        if (getBoundVariable() != -1)
            binding.setVariable(getBoundVariable(), item)

        binding.executePendingBindings()
    }

    @Deprecated(
        "Removal on Databinding. Should not use with data binding!",
        ReplaceWith(""),
        DeprecationLevel.ERROR
    )
    override fun bindItem(item: RBVM) = bindVariables(item)

    @Deprecated(
        "Removal on Databinding. Should not use with data binding!",
        ReplaceWith(""),
        DeprecationLevel.ERROR
    )
    override fun bindItem(item: RBVM, onItemClick: ((RBVM, Int) -> Unit)?) = Unit

}

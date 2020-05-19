package com.kaloglu.library.databinding4vm.adapter

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import com.kaloglu.library.ui.adapter.BaseViewHolder
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.databinding4vm.interfaces.DataBoundViewHolder

class BoundViewHolder<RI>
constructor(private val binding: ViewDataBinding) :
    BaseViewHolder<RI>(binding.root),
    DataBoundViewHolder<RI>
        where RI : RecyclerItem {

    lateinit var setBindingVariable: (ViewDataBinding, RI) -> Unit

    override val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
        binding.lifecycleOwner = this
        onCreated()
    }

    override fun bind(item: RI) = bindVariable(item)

    private fun bindVariable(item: RI) {
        if (::setBindingVariable.isInitialized)
            setBindingVariable(binding, item)

        binding.executePendingBindings()
    }

}

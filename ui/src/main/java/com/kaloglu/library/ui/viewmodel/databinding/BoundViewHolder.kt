package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import com.kaloglu.library.ui.BaseViewHolder
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBoundViewHolder
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel

class BoundViewHolder<RI>
constructor(private val binding: ViewDataBinding) :
    BaseViewHolder<RI>(binding.root), DataBoundViewHolder<RI>
        where RI : RecyclerItem {

    override val lifecycleRegistry = LifecycleRegistry(this)

    private var paused: Boolean = false

    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
        binding.lifecycleOwner = this
        onCreated()
    }

    override fun bindVariables(item: RI) {
        if (getBoundVariable() != -1)
            binding.setVariable(getBoundVariable(), item)
        bind(item)
        binding.executePendingBindings()
    }

    override fun bind(item: RI) = Unit

    @Deprecated(
        "Removal on Databinding. Should not use with data binding!",
        ReplaceWith(""),
        DeprecationLevel.ERROR
    )
    override fun bind(item: RI, onItemClick: ((RI, Int) -> Unit)?) = Unit

    fun onCreated() {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    fun onAttach() {
        if (paused) {
            lifecycleRegistry.currentState = Lifecycle.State.RESUMED
            paused = false
        } else {
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }
    }

    fun onDetach() {
        paused = true
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    fun onDestroyed() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}

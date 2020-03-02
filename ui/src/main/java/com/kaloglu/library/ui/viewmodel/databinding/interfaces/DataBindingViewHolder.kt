package com.kaloglu.library.ui.viewmodel.databinding.interfaces

import com.kaloglu.library.ui.interfaces.ViewHolder
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel

interface DataBindingViewHolder<RBVM : RecyclerBindableViewModel<*>> : ViewHolder<RBVM> {

    fun bindVariables(item: RBVM)

    fun getBoundVariable() = -1

}

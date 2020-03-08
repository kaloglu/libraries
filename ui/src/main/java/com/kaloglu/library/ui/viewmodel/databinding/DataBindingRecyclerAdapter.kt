package com.kaloglu.library.ui.viewmodel.databinding

import android.view.ViewGroup
import com.kaloglu.library.ui.BaseRecyclerAdapter
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class DataBindingRecyclerAdapter<RBVM : RecyclerBindableViewModel<*>>
    : BaseRecyclerAdapter<RBVM, BindingViewHolder<RBVM>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingViewHolder<RBVM>(parent.inflateViewHolderBinding(viewType))

    override fun onBindViewHolder(holder: BindingViewHolder<RBVM>, position: Int) =
        holder.bindVariables(getItem(position))

}

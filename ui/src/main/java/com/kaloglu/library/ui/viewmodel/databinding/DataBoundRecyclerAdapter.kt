package com.kaloglu.library.ui.viewmodel.databinding

import android.view.ViewGroup
import com.kaloglu.library.ui.BaseRecyclerAdapter
import com.kaloglu.library.ui.viewmodel.databinding.model.RecyclerBindableViewModel

abstract class DataBoundRecyclerAdapter<RBVM> : BaseRecyclerAdapter<RBVM, BoundViewHolder<RBVM>>()
        where RBVM : RecyclerBindableViewModel<*, *> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BoundViewHolder<RBVM>(parent.inflateViewHolderBinding(viewType))

    override fun onBindViewHolder(holder: BoundViewHolder<RBVM>, position: Int) =
        holder.bindVariables(getItem(position))

}

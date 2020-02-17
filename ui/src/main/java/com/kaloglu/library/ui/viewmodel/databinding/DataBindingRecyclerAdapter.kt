package com.kaloglu.library.ui.viewmodel.databinding

import android.view.View
import android.view.ViewGroup
import com.kaloglu.library.ui.BaseModel
import com.kaloglu.library.ui.BaseRecyclerAdapter

abstract class DataBindingRecyclerAdapter<M : BaseModel, VH : DataBindingViewHolder<M>>
    : BaseRecyclerAdapter<M, VH> {

    override var onItemClick: ((M) -> Unit) = {}
    override var onViewClick: ((M, View) -> Unit) = { _, _ -> }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bindItem(items[position], onItemClick)

    override fun getItemCount() = items.size

}

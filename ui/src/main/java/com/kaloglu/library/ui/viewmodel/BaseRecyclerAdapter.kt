package com.kaloglu.library.ui.viewmodel

import android.view.View
import android.view.ViewGroup
import com.kaloglu.library.ui.BaseRecyclerAdapter
import com.kaloglu.library.ui.BaseViewHolder
import com.kaloglu.library.ui.DiffItemSimpleCallback
import com.kaloglu.library.ui.RecyclerItem

abstract class BaseRecyclerAdapter<RI, VH>(
    diffUtilCallback: DiffItemSimpleCallback<RI> = DiffItemSimpleCallback()
) : BaseRecyclerAdapter<RI, VH>(diffUtilCallback)
        where RI : RecyclerItem, VH : BaseViewHolder<RI> {

    override var onItemClick: ((RI, Int) -> Unit)? = null
    override var onViewClick: ((RI, View, Int) -> Unit)? = null

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bind(getItem(position), onItemClick)

}

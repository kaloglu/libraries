package com.kaloglu.library.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItemAdapter

abstract class BaseRecyclerAdapter<RI, VH> :
    ListAdapter<RI, VH>(AsyncDifferConfig.Builder<RI>(DiffItemSimpleCallback<RI>()).build()),
    ClickableRecyclerItemAdapter<RI>
        where RI : RecyclerItem, VH : BaseViewHolder<RI> {

    override var onItemClick: ((RI, Int) -> Unit)? = null
    override var onViewClick: ((RI, View, Int) -> Unit)? = null

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bindItem(getItem(position), onItemClick)

    /*class Seperator(
        override var parent: RecyclerItem,
        @LayoutRes override var layoutId: Int
    ) : RecyclerItem {
        override var position = -1

        override fun <T : Any> getId(): T = -1 as T
    }*/
}

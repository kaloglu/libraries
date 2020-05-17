package com.kaloglu.library.ui

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<RI>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer, ClickableRecyclerItem<RI>,
    ViewHolder<RI>
        where RI : RecyclerItem {

    abstract val lifecycleRegistry: LifecycleRegistry

    override var onViewClick: ((RI, View, Int) -> Unit)? = null

    override fun setOnViewClick(onViewClick: ((RI, View, Int) -> Unit)?): BaseViewHolder<RI> {
        this.onViewClick = onViewClick
        return this
    }

    override fun bind(item: RI, onItemClick: ((RI, Int) -> Unit)?) {

        with(itemView) {
            setOnClickListener { onItemClick?.invoke(item, adapterPosition) }
            bind(item)
        }
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry
}
package com.kaloglu.library.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<RI : RecyclerItem>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer, ClickableRecyclerItem<RI>, ViewHolder<RI> {

    override var onViewClick: ((RI, View, Int) -> Unit)? = null

    override fun setOnViewClick(onViewClick: ((RI, View, Int) -> Unit)?): BaseViewHolder<RI> {
        this.onViewClick = onViewClick
        return this
    }

    override fun bindItem(item: RI, onItemClick: ((RI, Int) -> Unit)?) {

        with(itemView) {
            setOnClickListener { onItemClick?.invoke(item, adapterPosition) }
            bindItem(item)
        }
    }
}
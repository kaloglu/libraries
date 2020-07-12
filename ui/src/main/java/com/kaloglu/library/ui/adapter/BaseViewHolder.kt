package com.kaloglu.library.ui.adapter

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItem
import com.kaloglu.library.ui.interfaces.ViewHolder
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<RI>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer, ClickableRecyclerItem<RI>,
    ViewHolder<RI>
        where RI : RecyclerItem {

    abstract val lifecycleRegistry: LifecycleRegistry

    private var paused: Boolean = false

    override var onViewClick: ((RI, View, Int) -> Unit)? = null
    override var onViewLongClick: (RI, View, Int) -> Boolean = { _, _, _ -> false }

    override fun bind(
        item: RI?,
        onItemClick: ((RI, Int) -> Unit)?,
        onItemLongClick: ((RI, Int) -> Boolean)
    ) {
        if (item == null) return

        containerView.setOnClickListener { onItemClick?.invoke(item, adapterPosition) }
        containerView.setOnLongClickListener { onItemLongClick.invoke(item, adapterPosition) }
        bind(item)
    }

    override fun setClicks(
        onViewClick: ((RI, View, Int) -> Unit)?,
        onViewLongClick: (RI, View, Int) -> Boolean
    ): BaseViewHolder<RI> {

        this.onViewClick = onViewClick
        this.onViewLongClick = onViewLongClick

        return this
    }

    override fun onAttach() {
        if (paused) {
            lifecycleRegistry.currentState = Lifecycle.State.RESUMED
            paused = false
        } else {
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }
    }

    override fun onCreated() {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    override fun onDetach() {
        paused = true
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override fun onDestroyed() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

}
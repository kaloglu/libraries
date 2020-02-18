package com.kaloglu.library.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItemAdapter
import kotlin.properties.Delegates

abstract class OldSchoolBaseRecyclerAdapter<RI : RecyclerItem, VH : BaseViewHolder<RI>>
    : RecyclerView.Adapter<VH>(), DiffAdapter, ClickableRecyclerItemAdapter<RI> {

    override var onItemClick: ((RI, Int) -> Unit)? = null
    override var onViewClick: ((RI, View, Int) -> Unit)? = null

    var items: List<RI> by Delegates.observable(emptyList()) { _, old, new ->
        notifyDiff(old, new) { o, n -> compareId<Any>(o, n) }
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bindItem(items[position], onItemClick)

    override fun getItemCount() = items.size

    protected open fun <T : Any> compareId(o: RI, n: RI) = o.getId<T>() == n.getId<T>()

    /*class Seperator(
        override var parent: RecyclerItem,
        @LayoutRes override var layoutId: Int
    ) : RecyclerItem {
        override var position = -1

        override fun <T : Any> getId(): T = -1 as T
    }*/
}

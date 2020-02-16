package com.kaloglu.library.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class BaseRecyclerAdapter<M : BaseModel, VH : BaseViewHolder<M>>
    : RecyclerView.Adapter<VH>(), DiffAdapter {

    var onItemClick: ((M) -> Unit) = {}
    var onViewClick: ((M, View) -> Unit) = { _, _ -> }

    var items: List<M> by Delegates.observable(emptyList()) { _, old, new ->
        notifyDiff(old, new) { o, n -> compareId<Any>(o, n) }
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder
            .setOnViewClick(onViewClick)
            .bindItem(items[position], onItemClick)

    override fun getItemCount() = items.size

    protected open fun <T : Any> compareId(o: M, n: M) = o.getId<T>() == n.getId<T>()
}

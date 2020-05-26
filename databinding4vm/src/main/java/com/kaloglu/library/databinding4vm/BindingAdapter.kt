package com.kaloglu.library.databinding4vm

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.databinding4vm.adapter.DataBoundRecyclerAdapter

@BindingAdapter("adapter")
fun <RI : RecyclerItem, A : DataBoundRecyclerAdapter<RI>> setRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: A?
) {
    recyclerView.adapter = adapter
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <RI : RecyclerItem> setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: MutableList<RI>
) {
    val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = recyclerView.adapter
    if (adapter != null) {
        (adapter as DataBoundRecyclerAdapter<RI>).submitList(items)
    }
}
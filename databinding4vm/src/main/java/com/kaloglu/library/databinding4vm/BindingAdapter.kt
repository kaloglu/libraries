package com.kaloglu.library.databinding4vm

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.databinding4vm.adapter.DataBoundListAdapter
import com.kaloglu.library.databinding4vm.adapter.DataBoundPagedListAdapter
import com.kaloglu.library.ui.RecyclerItem

@BindingAdapter("adapter")
fun <RI : RecyclerItem, A : RecyclerView.Adapter<*>> setRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: A?
) {
    recyclerView.adapter = adapter
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <RI : RecyclerItem> setItems(
    recyclerView: RecyclerView,
    items: Collection<RI>
) {
    recyclerView.adapter?.apply {
        when (items) {
            is MutableList<RI> -> {
                (this as DataBoundListAdapter<RI>)
                submitList(items)
            }
            is PagedList<RI> -> {
                (this as DataBoundPagedListAdapter<RI>)
                submitList(items)
            }
        }
    }

}
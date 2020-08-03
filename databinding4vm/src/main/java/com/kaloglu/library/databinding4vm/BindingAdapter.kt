package com.kaloglu.library.databinding4vm

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.databinding4vm.adapter.DataBoundListAdapter
import com.kaloglu.library.databinding4vm.adapter.DataBoundPagingDataAdapter
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
    items: List<RI>
) {
    recyclerView.adapter?.apply {
        if (this is DataBoundListAdapter<*>) {
            (this as DataBoundListAdapter<RI>)
            submitList(items)
        }
    }

}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("datas")
fun <RI : RecyclerItem> setDatas(
    recyclerView: RecyclerView,
    datas: PagingData<RI>,
    lifecycleOwner: LifecycleOwner
) {
    recyclerView.adapter?.apply {
        if (this is DataBoundPagingDataAdapter<*>) {
            (this as DataBoundPagingDataAdapter<RI>)
            submitData(lifecycleOwner.lifecycle, datas)
        }
    }

}
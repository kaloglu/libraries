@file:JvmName("UiViewUtil")

package com.kaloglu.library.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.adapter.BaseListAdapter
import com.kaloglu.library.ui.interfaces.ClickableRecyclerItemAdapter

@JvmOverloads
fun <A : BaseListAdapter<*, *>> RecyclerView.setup(
    adapter: A,
    layoutManager: RecyclerView.LayoutManager? = null,
    @DrawableRes seperatorDrawable: Int? = null
): A {
    this.layoutManager = layoutManager ?: LinearLayoutManager(context)
    this.adapter = adapter
    seperatorDrawable?.let {
        addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(ContextCompat.getDrawable(context!!, it)!!)
            }
        )
    }
    setHasFixedSize(true)
    return adapter
}

fun <A : ClickableRecyclerItemAdapter<RI>, RI : RecyclerItem>
        A.setItemClickListener(onClick: ((RI, Int) -> Unit)): A {
    this.onItemClick = onClick
    return this
}

fun <A : ClickableRecyclerItemAdapter<RI>, RI : RecyclerItem>
        A.setItemLongClickListener(onLongClick: ((RI, Int) -> Boolean)): A {
    this.onItemLongClick = onLongClick
    return this
}

fun <A : ClickableRecyclerItemAdapter<RI>, RI : RecyclerItem>
        A.setViewClickListener(onClick: ((RI, View, Int) -> Unit)): A {
    this.onViewClick = onClick
    return this
}

fun <A : ClickableRecyclerItemAdapter<RI>, RI : RecyclerItem>
        A.setViewLongClickListener(onLongClick: ((RI, View, Int) -> Boolean)): A {
    this.onViewLongClick = onLongClick
    return this
}

inline fun <reified F : BaseFragment> F.putArgs(argsBuilder: Bundle.() -> Unit = {}) = apply {

    arguments = Bundle().apply(argsBuilder)
}

@file:JvmName("UiViewUtil")
package com.kaloglu.library.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaloglu.library.ui.adapter.BaseRecyclerAdapter

@JvmOverloads
fun <A : BaseRecyclerAdapter<*, *>> RecyclerView.setup(
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

fun <A : BaseRecyclerAdapter<RI, *>, RI : RecyclerItem>
        A.setItemClickListener(onClick: ((RI, Int) -> Unit)): BaseRecyclerAdapter<RI, *> {
    this.onItemClick = onClick
    return this
}

fun <A : BaseRecyclerAdapter<RI, *>, RI : RecyclerItem>
        A.setViewClickListener(onClick: ((RI, View, Int) -> Unit)): BaseRecyclerAdapter<RI, *> {
    this.onViewClick = onClick
    return this
}

inline fun <reified F : BaseFragment> F.putArgs(argsBuilder: Bundle.() -> Unit = {}) = apply {
    arguments = Bundle().apply(argsBuilder)
}

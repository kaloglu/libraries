package com.kaloglu.library.ui

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

interface DiffAdapter {

    fun <M : BaseModel> RecyclerView.Adapter<*>.notifyDiff(
        old: List<M>,
        new: List<M>,
        compare: (M, M) -> Boolean
    ) = DiffUtil.calculateDiff(
        DiffUtilSimpleCallback(compare, old, new)
    ).dispatchUpdatesTo(this)

}

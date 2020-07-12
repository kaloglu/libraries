package com.kaloglu.library.ui.adapter

import com.kaloglu.library.ui.DiffItemSimpleCallback
import com.kaloglu.library.ui.RecyclerItem

@Deprecated(
    "Removal",
    replaceWith = ReplaceWith("BaseListAdapter"), level = DeprecationLevel.ERROR
)
abstract class BaseRecyclerAdapter<RI, VH>(
    diffUtilCallback: DiffItemSimpleCallback<RI> = DiffItemSimpleCallback()
) : BaseListAdapter<RI, VH>(diffUtilCallback)
        where RI : RecyclerItem, VH : BaseViewHolder<RI>

package com.kaloglu.library.databinding4vm.adapter

import com.kaloglu.library.ui.DiffItemSimpleCallback
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.adapter.BaseListAdapter

@Deprecated(
    "Removal",
    replaceWith = ReplaceWith(
        "DataBoundListAdapter<RI>(\n" +
                "    diffUtilCallback: DiffItemSimpleCallback<RI> = DiffItemSimpleCallback()\n" +
                ")"
    ), level = DeprecationLevel.ERROR
)
abstract class DataBoundRecyclerAdapter<RI>(
    diffUtilCallback: DiffItemSimpleCallback<RI> = DiffItemSimpleCallback()
) : BaseListAdapter<RI, BoundViewHolder<RI>>(diffUtilCallback)
        where RI : RecyclerItem

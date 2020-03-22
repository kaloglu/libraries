package com.kaloglu.library.ui

import androidx.recyclerview.widget.DiffUtil

open class DiffUtilSimpleCallback<M : BaseModel>
constructor(
    private val compare: (M, M) -> Boolean,
    private val old: List<M>,
    private val new: List<M>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        compare(old[oldItemPosition], new[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition] == new[newItemPosition]

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size
}

open class DiffItemSimpleCallback<M : BaseModel> : DiffUtil.ItemCallback<M>() {

    override fun areItemsTheSame(oldItem: M, newItem: M) =
        oldItem.getID<Any>() == newItem.getID()

    override fun areContentsTheSame(oldItem: M, newItem: M) =
        oldItem.equals(newItem)
}


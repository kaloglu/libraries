package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.BaseViewHolder

class DataBindingViewHolder<M>(
    val binding: ViewDataBinding,
    val viewType: Int
) : BaseViewHolder<M>(binding.root) {

    @Deprecated(
        "Removal on Databinding. Should not use with data binding!",
        ReplaceWith(""),
        DeprecationLevel.ERROR
    )
    override fun bindItem(item: M) = Unit

}

package com.kaloglu.library.ui.databinding

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.BaseViewHolder

abstract class DataBindingViewHolder<M>(
    val binding: ViewDataBinding,
    val viewType: Int
) : BaseViewHolder<M>(binding.root)

@file:JvmName("UiDataBindingUtil")

package com.kaloglu.library.ui.viewmodel.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.databinding.ViewDataBinding

/**
 * if you don't have inflater
 *
 * parent.inflateBinding(layoutId = R.layout#Name)
 *
 * @receiver ViewGroup
 *
 * @param layoutId @LayoutRes
 *
 * @return ViewDataBinding
 *
 * */
fun <VDB : ViewDataBinding> LayoutInflater.inflateViewBinding(
    container: ViewGroup?,
    @LayoutRes layoutId: Int,
    onInflate: VDB.() -> Unit
): VDB = DataBindingUtil.inflate<VDB>(this, layoutId, container, false)
    .apply {
        onInflate(this)
    }

fun ViewGroup.inflateViewHolderBinding(@LayoutRes layoutId: Int): ViewDataBinding =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, false)

@InverseMethod("stringToInt")
fun Int.intToString(): String {
    return toString()
}

fun String.stringToInt(): Int {
    if (this == "")
        return 0
    return trim().toInt()
}
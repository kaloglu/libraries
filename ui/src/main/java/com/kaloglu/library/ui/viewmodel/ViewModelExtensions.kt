@file:JvmName("UiViewModelUtil")

package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.ViewModelProviders
import com.kaloglu.library.ui.BaseActivity

inline fun <reified VM : BaseViewModel> ViewModelFragment<VM>.getViewModel(noinline creator: (() -> VM)? = null): VM {
    return if (creator == null)
        ViewModelProviders.of(this).get(VM::class.java)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(VM::class.java)
}

inline fun <reified VM : BaseViewModel> BaseActivity.getViewModel(noinline creator: (() -> VM)? = null): VM {
    return if (creator == null)
        ViewModelProviders.of(this).get(VM::class.java)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(VM::class.java)
}
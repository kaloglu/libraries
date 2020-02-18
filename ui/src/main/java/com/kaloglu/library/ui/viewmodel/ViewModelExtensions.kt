@file:JvmName("UiViewModelUtil")

package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.ViewModelProviders
import com.kaloglu.library.ui.BaseActivity

fun <VM : BaseViewModel> ViewModelFragment<VM>.getViewModel(
        viewModelClass: Class<VM>,
        creator: (() -> VM)? = null
): VM {
    return if (creator == null)
        ViewModelProviders.of(this).get(viewModelClass)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(viewModelClass)
}

fun <VM : BaseViewModel> BaseActivity.getViewModel(
        viewModelClass: Class<VM>,
        creator: (() -> VM)? = null
): VM {
    return if (creator == null)
        ViewModelProviders.of(this).get(viewModelClass)
    else
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(viewModelClass)
}
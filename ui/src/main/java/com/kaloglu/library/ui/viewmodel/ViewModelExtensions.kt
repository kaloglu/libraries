@file:JvmName("UiViewModelUtil")

package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.kaloglu.library.ui.BaseApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
fun <VM : BaseViewModel<*,*>> ViewModelStoreOwner.getViewModel(
    application: BaseApplication, viewModelClass: Class<VM>
) = ViewModelProvider(this, BaseViewModelFactory(application)).get(viewModelClass)

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
fun <A : BaseApplication, VM : BaseViewModel<*,*>> ViewModelStoreOwner.getViewModel(
    factory: RepositoryViewModelFactory<A>,
    viewModelClass: Class<VM>
) = ViewModelProvider(this, factory).get(viewModelClass)
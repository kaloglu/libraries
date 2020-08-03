package com.kaloglu.library.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaloglu.library.ui.BaseApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
open class ViewModelFactory<A, BVM>(
    private val application: A,
    private val lifecycle: Lifecycle,
    private val viewModel: BVM
) : ViewModelProvider.AndroidViewModelFactory(application)
        where A : BaseApplication, BVM : BaseViewModel<*, *> {

    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>) =
        when {
            BaseViewModel::class.java.isAssignableFrom(modelClass) -> {
                createViewModel(
                    modelClass
                        .getConstructor(application::class.java)
                        .newInstance(application) as BaseViewModel<*, *>
                ) as VM
            }
            else ->
                super.create(modelClass)
        }

    @CallSuper
    open fun createViewModel(createdViewModel: BaseViewModel<*, *>) =
        createdViewModel.apply {
            lifecycle.addObserver(this)
            attachViewModel(viewModel)
        }

}

package com.kaloglu.library.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaloglu.library.ui.BaseApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
open class ViewModelFactoryWithAttachViewModel<A, VM>(
    override val application: A,
    override val lifecycle: Lifecycle,
    vararg _viewModels: VM
) : ViewModelFactory<A>(
    application,
    lifecycle
) where A : BaseApplication, VM : BaseViewModel<*, *> {

    private var viewModels = _viewModels

    @CallSuper
    override fun onAttach(viewModel: BaseViewModel<*, *>) = viewModel.attachViewModel(*viewModels)

}

@ExperimentalCoroutinesApi
open class ViewModelFactory<A>(
    open val application: A,
    open val lifecycle: Lifecycle? = null
) : ViewModelProvider.AndroidViewModelFactory(application) where A : BaseApplication {

    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>) =
        when {
            BaseViewModel::class.java.isAssignableFrom(modelClass) -> {
                modelClass
                    .getConstructor(application::class.java)
                    .newInstance(application)
                    .apply {
                        this as BaseViewModel<*, *>
                        this.onCreateViewModel()
                    } as VM
            }
            else -> super.create(modelClass)
        }

    protected fun BaseViewModel<*, *>.onCreateViewModel() {
        lifecycle?.addObserver(this)
        onAttach(this)
    }

    open fun onAttach(viewModel: BaseViewModel<*, *>) = Unit

}


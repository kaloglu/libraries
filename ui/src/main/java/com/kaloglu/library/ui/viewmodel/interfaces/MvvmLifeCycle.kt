package com.kaloglu.library.ui.viewmodel.interfaces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.kaloglu.library.ui.interfaces.ViewLifecycle
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.mvi.Resource

interface MvvmLifeCycle<VM> : ViewLifecycle where VM : BaseViewModel<*, *> {
    val viewModel: VM

    fun observeViewModel(viewLifecycleOwner: LifecycleOwner) {
        with(viewModel) {
            stateLiveData.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is Resource.Success -> onStateSuccess(it)
                    is Resource.Error -> onStateFailure(it)
                    is Resource.Empty -> onStateEmpty(it)
                    is Resource.Loading -> onStateLoading(it)
                    is Resource.Init -> onStateInit(it)
                    is Resource.Custom -> onStateCustom(it)
                }
            })
        }
    }

    fun onStateInit(resource: Resource.Init) = showToast(resource::class.java.simpleName)

    fun onStateLoading(resource: Resource.Loading) = showToast(resource::class.java.simpleName)

    fun onStateSuccess(resource: Resource.Success<*>) = showToast(resource::class.java.simpleName)

    fun onStateEmpty(resource: Resource.Empty) = showToast(resource::class.java.simpleName)

    fun onStateFailure(resource: Resource.Error) = showToast(resource.message)

    fun onStateCustom(resource: Resource.Custom) = showToast(resource::class.java.simpleName)

}

package com.kaloglu.library.ui.viewmodel.interfaces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.kaloglu.library.ui.interfaces.ViewLifecycle
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.mvi.State

interface MvvmLifeCycle<VM> : ViewLifecycle where VM : BaseViewModel<*, *> {
    val viewModel: VM

    fun observeViewModel(viewLifecycleOwner: LifecycleOwner) {
        with(viewModel) {
            stateLiveData.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is State.Done -> onStateSuccess(it)
                    is State.Error -> onStateFailure(it)
                    is State.Empty -> onStateEmpty(it)
                    is State.Loading -> onStateLoading(it)
                    is State.Init -> onStateInit(it)
                    is State.Custom -> onStateCustom(it)
                }
            })
        }
    }

    fun onStateInit(state: State.Init) = showToast(state::class.java.simpleName)

    fun onStateLoading(state: State.Loading) = showToast(state::class.java.simpleName)

    fun onStateSuccess(state: State.Done) = showToast(state::class.java.simpleName)

    fun onStateEmpty(state: State.Empty) = showToast(state::class.java.simpleName)

    fun onStateFailure(state: State.Error) = showToast(state.error.message)

    fun onStateCustom(state: State.Custom) = showToast(state::class.java.simpleName)

}

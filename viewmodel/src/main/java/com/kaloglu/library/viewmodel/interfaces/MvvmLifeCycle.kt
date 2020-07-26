package com.kaloglu.library.viewmodel.interfaces

import androidx.lifecycle.LifecycleOwner
import com.kaloglu.library.ui.interfaces.ViewLifecycle
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.onEach

@ExperimentalCoroutinesApi
interface MvvmLifeCycle<VM, S> : ViewLifecycle where VM : BaseViewModel<*, S>, S : State {
    val viewModel: VM

    fun observeViewModel(viewLifecycleOwner: LifecycleOwner) {
        with(viewModel) {
            stateFlow.onEach {
                when (it) {
                    is State.Success -> onStateSuccess(it)
                    is State.Error -> onStateFailure(it)
                    is State.Empty -> onStateEmpty(it)
                    is State.Loading -> onStateLoading(it)
                    is State.Init -> onStateInit(it)
                    is State.Custom -> onState(it)
                }
            }
        }
    }

    fun <S : State.Init> onStateInit(init: S) = showToast(init::class.java.simpleName)

    fun <S : State.Loading> onStateLoading(loading: S) = showToast(loading::class.java.simpleName)

    fun <S : State.Success> onStateSuccess(success: S) = showToast(success::class.java.simpleName)

    fun <S : State.Empty> onStateEmpty(empty: S) = showToast(empty::class.java.simpleName)

    fun <S : State.Error> onStateFailure(error: S) = showToast(error.error.message)

    fun <S : State.Custom> onState(state: S) = showToast(state::class.java.simpleName)

}

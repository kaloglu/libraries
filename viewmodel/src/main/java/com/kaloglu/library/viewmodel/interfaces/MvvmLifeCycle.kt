package com.kaloglu.library.viewmodel.interfaces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.kaloglu.library.ui.interfaces.ViewLifecycle
import com.kaloglu.library.ui.models.ErrorModel
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
interface MvvmLifeCycle<VM, E, S> :
    ViewLifecycle where VM : BaseViewModel<E, S>, E : Event, S : State {
    val viewModel: VM

    fun observeViewModel(viewLifecycleOwner: LifecycleOwner) {
        viewModel.viewModelScope.launch {
            viewModel.stateFlow
                .filterNotNull()
                .collect {
                    when (it) {
                        is State.Idle -> onStateIdle()
                        else -> {
                            when (it) {
                                is State.Failure -> onStateFailure(it.error)
                                is State.Init -> onStateInit()
                                is State.Loading -> onStateLoading(it.loading)
                                is State.Empty -> onStateEmpty()
                                is State.Done -> onStateDone(it)
                                else -> onState(it)
                            }
                            viewModel.stateIdle()
                        }
                    }
                }

            viewModel.eventFlow
                .filterNotNull()
                .collect {
                    when (it) {
                        is Event.Idle -> {
                        }
                        else -> {
                            onEvent(it)
                            viewModel.eventIdle()
                        }
                    }
                }
        }
    }

    fun onStateDone(it: State.Done) = showToast("done")

    fun onStateInit() = showToast("init")

    fun onStateIdle() = showToast("idle")

    fun onStateLoading(loading: Boolean) = showToast("loading")

    fun onStateEmpty() = showToast("empty")

    fun onStateFailure(error: ErrorModel) = showToast(error.message)

    fun onState(state: S) = showToast(state::class.java.simpleName)

    fun onEvent(event: E) = showToast(event::class.java.simpleName)

}

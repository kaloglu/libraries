package com.kaloglu.library.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalCoroutinesApi
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application),
    LifecycleObserver
        where E : Event, S : State {

    abstract val stateFlow: MutableStateFlow<S>
    abstract val eventFlow: MutableStateFlow<E>

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onInit() {
        eventFlow.onEach(::onEvent).launchIn(viewModelScope)
    }

    fun postEvent(event: E) {
        eventFlow.value = event
    }

    fun postState(state: S) {
        stateFlow.value = state
    }

    protected open suspend fun onEvent(event: E) = Unit
}

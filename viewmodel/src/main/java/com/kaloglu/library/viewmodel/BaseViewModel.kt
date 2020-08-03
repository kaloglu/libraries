package com.kaloglu.library.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.viewModelScope
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalCoroutinesApi
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application),
    LifecycleObserver
        where E : Event, S : State {

    val stateFlow: StateFlow<S?>
        get() = _stateFlow

    private val _stateFlow: MutableStateFlow<S?> = MutableStateFlow(null)
    private val _eventFlow: MutableStateFlow<E?> = MutableStateFlow(null)

    init {
        _eventFlow
            .filterNotNull()
            .onEach(::onEvent)
            .launchIn(viewModelScope)
    }

    open fun <VM : BaseViewModel<*, *>> attachViewModel(vararg viewModels: VM) = Unit

    fun postEvent(event: E) {
        _eventFlow.value = event
    }

    protected fun postState(state: S) {
        _stateFlow.value = state
    }

    protected open suspend fun onEvent(event: E) = Unit
}

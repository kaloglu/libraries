package com.kaloglu.library.viewmodel

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalCoroutinesApi
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application)
        where E : Event, S : State {

    abstract val stateFlow: MutableStateFlow<S>
    abstract val eventFlow: MutableStateFlow<E>

    init {
        Log.e("VIEWMODEL", "INIT!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    abstract fun onInit()

    fun postEvent(event: E) {
        eventFlow.value = event
    }

    fun postState(state: S) {
        stateFlow.value = state
    }

    @CallSuper
    protected open fun onEvent(event: E) {
        if (event is Event.Init) {
            onInit()
            return
        }
    }
}

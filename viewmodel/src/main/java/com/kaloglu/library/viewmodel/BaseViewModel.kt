package com.kaloglu.library.viewmodel

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseViewModel<E, S>(application: BaseApplication) : AndroidViewModel(application)
        where E : Event, S : State {

    val stateLiveData = MediatorLiveData<S>()

    private val eventLiveData = MutableLiveData<E>()

    init {
        stateLiveData.addSource(eventLiveData, ::onEvent)
        Log.e("VIEWMODEL", "INIT!")
    }

    @CallSuper
    open fun postEvent(event: E) = eventLiveData.postValue(event)

    @CallSuper
    protected open fun onEvent(event: E) {
        when (event) {
            is Event.Init -> onInit()
            else -> {
            }
        }
    }

    fun postState(state: S) = stateLiveData.postValue(state)

    protected fun <T> LiveData<T>.mapToEvent(onChanged: (T?) -> E) {
        stateLiveData.addSource(this) {
            postEvent(onChanged(it))
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    abstract fun onInit()
}

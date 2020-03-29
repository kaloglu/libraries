package com.kaloglu.library.ui.viewmodel

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.*
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.State

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

    protected fun <T> LiveData<T>.mapToEvent(onChanged: (T?) -> E) {
        stateLiveData.addSource(this) {
            postEvent(onChanged(it))
        }
    }

    fun postState(state: S) = stateLiveData.postValue(state)

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    abstract fun onInit()
}

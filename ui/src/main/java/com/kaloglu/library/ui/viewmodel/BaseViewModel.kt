package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class BaseViewModel<S : State> : ViewModel() {
    val state: LiveData<S>
        get() = _state

    private val _state: MutableLiveData<S> = MutableLiveData()

    init {
        state.observeForever {
            onState(it)
        }
    }

    abstract fun onState(state: S)

    fun postState(state: S) {
        _state.postValue(state)
    }

}

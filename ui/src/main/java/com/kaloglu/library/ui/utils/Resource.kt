package com.kaloglu.library.ui.utils

import com.kaloglu.library.ui.models.ErrorModel
import com.kaloglu.library.ui.viewmodel.states.State

sealed class Resource<T> : State.DataState {
    open val data: T? = null

    class Success<T>(override val data: T) : Resource<T>(), State.DataState.Success
    class Failure<T>(override val error: ErrorModel) : Resource<T>(), State.DataState.Error
    class Loading<T> : Resource<T>(), State.DataState.Loading

    fun handleResult(
        successBlock: Success<T>.() -> Unit = {},
        failureBlock: Failure<T>.() -> Unit = {},
        loadingBlock: Loading<T>.() -> Unit = {}
    ) {
        when (this) {
            is Success -> successBlock()
            is Failure -> failureBlock()
            is Loading -> loadingBlock()
        }
    }
}

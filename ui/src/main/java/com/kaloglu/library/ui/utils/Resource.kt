package com.kaloglu.library.ui.utils

import com.kaloglu.library.ui.models.ErrorModel
import com.kaloglu.library.ui.viewmodel.states.State

sealed class Resource<T> : State.DataState {
    open val data: T? = null

    class Success<T>(override val data: T) : Resource<T>(), State.DataState.Success
    class Failure(override val error: ErrorModel) : Resource<Nothing>(), State.DataState.Error
    object Loading : Resource<Nothing>(), State.DataState.Loading

    fun handleResult(
        successBlock: Success<T>.() -> Unit = {},
        failureBlock: Failure.() -> Unit = {},
        loadingBlock: Loading.() -> Unit = {}
    ) {
        when (this) {
            is Success -> successBlock()
            is Failure -> failureBlock()
            is Loading -> loadingBlock()
        }
    }
}

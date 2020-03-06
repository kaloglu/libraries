package com.kaloglu.library.ui.utils

import com.kaloglu.library.ui.models.ErrorModel

sealed class Resource<out T> {
    open val body: T? = null
    open val error: ErrorModel? = null
    open val isLoading: Boolean = false

    data class Success<out T>(override val body: T) : Resource<T>()
    data class Failure(
        override val error: ErrorModel = ErrorModel(
            Constants.UNKNOWN_ERROR_CODE,
            Constants.UNKNOWN_ERROR
        )
    ) : Resource<Nothing>()

    class Loading : Resource<Nothing>()
    class NoInternet : Resource<Nothing>()
    class Cancelled : Resource<Nothing>()
    class TimeOut : Resource<Nothing>()
}

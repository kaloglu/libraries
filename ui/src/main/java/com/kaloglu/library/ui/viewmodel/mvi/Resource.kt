package com.kaloglu.library.ui.viewmodel.mvi

sealed class Resource<out T> {
    open val data: T? = null
    open val message: String? = null

    data class Success<out T>(override val data: T) : Resource<T>()

    data class Error(override val message: String) : Resource<Nothing>()

    object Loading : Resource<Nothing>()

    object Empty : Resource<Nothing>()

    object Init : Resource<Nothing>()

    object Custom : Resource<Nothing>()
}
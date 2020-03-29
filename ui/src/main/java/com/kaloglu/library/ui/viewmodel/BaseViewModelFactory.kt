package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaloglu.library.ui.BaseApplication

@Suppress("MemberVisibilityCanBePrivate")
open class BaseViewModelFactory<A>(val application: A, val lifecycle: Lifecycle) :
    ViewModelProvider.AndroidViewModelFactory(application)
        where A : BaseApplication {

    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>) =
        when {
            BaseViewModel::class.java.isAssignableFrom(modelClass) ->
                modelClass.getConstructor(application::class.java).newInstance(application)
            else ->
                super.create(modelClass)
        }
}

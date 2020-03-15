package com.kaloglu.library.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.interfaces.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@Suppress("MemberVisibilityCanBePrivate")
open class BaseViewModelFactory<A : BaseApplication>(val application: A) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    @FlowPreview
    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>) =
        when {
            BaseViewModel::class.java.isAssignableFrom(modelClass) ->
                modelClass.getConstructor(application::class.java).newInstance(application)
            else ->
                super.create(modelClass)
        }
}

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@Suppress("MemberVisibilityCanBePrivate")
open class RepositoryViewModelFactory<A : BaseApplication>(
    val application: A,
    val repository: Repository<*>
) : ViewModelProvider.AndroidViewModelFactory(application) {

    @FlowPreview
    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>) =
        when {
            BaseViewModel::class.java.isAssignableFrom(modelClass) ->
                modelClass.getConstructor(application::class.java, repository::class.java)
                    .newInstance(application, repository)
            else ->
                super.create(modelClass)
        }
}

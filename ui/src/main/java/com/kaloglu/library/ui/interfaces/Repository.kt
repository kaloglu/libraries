package com.kaloglu.library.ui.interfaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kaloglu.library.ui.BaseModel
import com.kaloglu.library.ui.utils.Resource

interface Repository<E : BaseModel> {

    fun insert(entity: E)

    fun delete(entity: E)

    fun update(entity: E)

    fun get(): LiveData<Resource<E>>

    val result: MutableLiveData<Resource<E>>

    fun asyncFinished(resource: Resource<E>?) {
        result.value = resource
    }
}
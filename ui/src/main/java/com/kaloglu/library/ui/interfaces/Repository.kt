package com.kaloglu.library.ui.interfaces

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.kaloglu.library.ui.BaseModel

interface Repository<E : BaseModel> : LifecycleObserver {

    fun insert(entity: E)

    fun delete(entity: E)

    fun update(entity: E)

    val data: LiveData<List<E>>

    fun addLifecycle(lifecycle: Lifecycle) = lifecycle.addObserver(this)
    fun removeLifecycle(lifecycle: Lifecycle) = lifecycle.removeObserver(this)

    fun registerLifecycle(lifecycle: Lifecycle) {
        removeLifecycle(lifecycle)
        addLifecycle(lifecycle)
    }

}
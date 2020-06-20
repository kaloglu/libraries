package com.kaloglu.library.ui.interfaces

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

interface Repository<E> : LifecycleObserver {

    suspend fun insert(entity: E)

    suspend fun delete(entity: E)

    suspend fun update(entity: E)

    fun addLifecycle(lifecycle: Lifecycle) = lifecycle.addObserver(this)
    fun removeLifecycle(lifecycle: Lifecycle) = lifecycle.removeObserver(this)

    fun registerLifecycle(lifecycle: Lifecycle) {
        removeLifecycle(lifecycle)
        addLifecycle(lifecycle)
    }

}
package com.kaloglu.library.ui.interfaces

import androidx.lifecycle.LiveData
import com.kaloglu.library.ui.BaseModel

interface Repository<E : BaseModel> {

    suspend fun insert(entity: E)

    suspend fun delete(entity: E)

    suspend fun update(entity: E)

    val data: LiveData<List<E>>

}
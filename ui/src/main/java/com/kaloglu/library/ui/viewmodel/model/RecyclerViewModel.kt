package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.Resource

abstract class RecyclerViewModel<E, R>(application: BaseApplication) :
    BaseViewModel<E, R>(application), RecyclerItem
        where E : Event, R: Resource<*>

package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.mvi.Event
import com.kaloglu.library.ui.viewmodel.mvi.State

abstract class RecyclerViewModel<E, S>(application: BaseApplication) :
    BaseViewModel<E, S>(application), RecyclerItem
        where E : Event, S : State

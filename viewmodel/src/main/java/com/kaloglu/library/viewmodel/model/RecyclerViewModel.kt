package com.kaloglu.library.viewmodel.model

import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.viewmodel.BaseViewModel
import com.kaloglu.library.viewmodel.mvi.Event
import com.kaloglu.library.viewmodel.mvi.State
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class RecyclerViewModel<E, S>(application: BaseApplication) :
    BaseViewModel<E, S>(application), RecyclerItem
        where E : Event, S : State {
}

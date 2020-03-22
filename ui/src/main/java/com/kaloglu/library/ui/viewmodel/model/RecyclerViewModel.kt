package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.BaseApplication
import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.states.State

abstract class RecyclerViewModel<M, S>(application: BaseApplication) :
    BaseViewModel<M, S>(application), RecyclerItem
        where M : Any, S : State

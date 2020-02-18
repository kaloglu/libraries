package com.kaloglu.library.ui.viewmodel.model

import com.kaloglu.library.ui.RecyclerItem
import com.kaloglu.library.ui.viewmodel.BaseViewModel

abstract class RecyclerViewModel : BaseViewModel(), RecyclerItem {

    override val parent: RecyclerViewModel? = null

}

package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm

abstract class ViewModelActivity<VM> : BaseActivity(), Mwwm<VM>
        where VM : BaseViewModel<*, *>

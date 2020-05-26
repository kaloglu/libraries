package com.kaloglu.library.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.viewmodel.interfaces.MvvmLifeCycle

abstract class ViewModelActivity<VM> : BaseActivity(),
    MvvmLifeCycle<VM>
        where VM : BaseViewModel<*, *>

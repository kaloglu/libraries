package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.viewmodel.interfaces.MvvmLifeCycle

abstract class ViewModelActivity<VM> : BaseActivity(), MvvmLifeCycle<VM>
        where VM : BaseViewModel<*, *>

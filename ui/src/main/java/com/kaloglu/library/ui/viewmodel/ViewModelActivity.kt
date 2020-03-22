package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm

abstract class ViewModelActivity<VM : BaseViewModel<*,*>> : BaseActivity(), Mwwm<VM>

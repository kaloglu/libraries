package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class ViewModelActivity<VM : BaseViewModel<*>> : BaseActivity(), Mwwm<VM>

package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
abstract class ViewModelActivity<VM : BaseViewModel<*,*>> : BaseActivity(), Mwwm<VM>

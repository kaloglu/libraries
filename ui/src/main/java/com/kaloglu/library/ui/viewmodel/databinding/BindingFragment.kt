package com.kaloglu.library.ui.viewmodel.databinding

import androidx.databinding.ViewDataBinding
import com.kaloglu.library.ui.viewmodel.BaseViewModel
import com.kaloglu.library.ui.viewmodel.ViewModelFragment
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.DataBinding

abstract class BindingFragment<VDB : ViewDataBinding, VM : BaseViewModel>
    : ViewModelFragment<VM>(), DataBinding<VDB>{


}

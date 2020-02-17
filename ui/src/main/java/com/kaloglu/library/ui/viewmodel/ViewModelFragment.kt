package com.kaloglu.library.ui.viewmodel

import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm

abstract class ViewModelFragment<VM : BaseViewModel> : BaseFragment(), Mwwm<VM>{
    override val activity by lazy { getActivity() as ViewModelActivity<*> }

    /*override val viewModel: VM
        get() = activity.getViewModel() as VM*/

}

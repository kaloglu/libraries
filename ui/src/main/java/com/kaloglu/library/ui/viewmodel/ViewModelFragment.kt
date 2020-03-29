package com.kaloglu.library.ui.viewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm
import com.kaloglu.library.ui.viewmodel.mvi.State

abstract class ViewModelFragment<VM>(@LayoutRes override val resourceLayoutId: Int = 0) :
    BaseFragment(resourceLayoutId), Mwwm<VM>
        where  VM : BaseViewModel<*, *> {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
    }

    override fun observeViewModel() {
        with(viewModel) {
            stateLiveData.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is State.Done -> onStateSuccess(it)
                    is State.Error -> onStateFailure(it)
                    is State.Empty -> onStateEmpty(it)
                    is State.Loading -> onStateLoading(it)
                    is State.Init -> onStateInit(it)
                    is State.Custom -> onStateCustom(it)
                }
            })
        }
    }

    protected open fun onStateInit(state: State.Init) = showToast(state::class.java.simpleName)

    protected open fun onStateLoading(state: State.Loading) = showToast(state::class.java.simpleName)

    protected open fun onStateSuccess(state: State.Done) = showToast(state::class.java.simpleName)

    protected open fun onStateEmpty(state: State.Empty) = showToast(state::class.java.simpleName)

    protected open fun onStateFailure(state: State.Error) = showToast(state.error.message)

    protected open fun onStateCustom(state: State.Custom) = showToast(state::class.java.simpleName)

}

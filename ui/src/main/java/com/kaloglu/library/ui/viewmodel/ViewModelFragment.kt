package com.kaloglu.library.ui.viewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.kaloglu.library.ui.BaseFragment
import com.kaloglu.library.ui.viewmodel.interfaces.Mwwm
import com.kaloglu.library.ui.viewmodel.states.State

abstract class ViewModelFragment<VM : BaseViewModel<*, *>>(
    @LayoutRes override val resourceLayoutId: Int = 0
) : BaseFragment(resourceLayoutId), Mwwm<VM> {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
    }

    override fun observeViewModel() {
        with(viewModel) {
            stateMediatorLiveData.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is State.UiState.Done -> onUiStateSuccess(it)
                    is State.UiState.Error -> onUiStateFailure(it)
                    is State.UiState.Empty -> onUiStateEmpty(it)
                    is State.UiState.Loading -> onUiStateLoading(it)
                    is State.UiState.Init -> onUiStateInit(it)
                    is State.UiState.CustomUi -> onUiStateCustom(it)
                }
            })
        }
    }

    protected open fun onUiStateInit(state: State.UiState.Init) = Unit

    protected open fun onUiStateLoading(state: State.UiState.Loading) = Unit

    protected open fun onUiStateSuccess(state: State.UiState.Done) = Unit

    protected open fun onUiStateEmpty(state: State.UiState.Empty) = Unit

    protected open fun onUiStateFailure(state: State.UiState.Error) = Unit

    protected open fun onUiStateCustom(state: State.UiState.CustomUi) = Unit
}

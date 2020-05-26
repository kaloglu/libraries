package com.kaloglu.library.ui.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.kaloglu.library.ui.BaseActivity
import com.kaloglu.library.ui.interfaces.DialogFragmentLifecycle

abstract class BaseDialogFragment @ContentView constructor(
    @LayoutRes open val resourceLayoutId: Int = 0
) : DialogFragment(), DialogFragmentLifecycle {

    override lateinit var containerView: View

    override val activity by lazy { getActivity() as BaseActivity }
    override val application by lazy { activity.application }

    override fun initUserInterface(savedInstanceState: Bundle?) {
        dialog?.let { dialog ->
            dialog.setOnShowListener {
                dialog.window?.let {
                    setDialogStyle(it)
                }
                dialog.setCancelable(false)
            }
            initUserInterface(dialog)
        }
    }

    override fun setDialogStyle(dialogWindow: Window) {
        dialogWindow.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(resourceLayoutId, parent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        containerView = view
        super.onViewCreated(view, savedInstanceState)
        initUserInterface(savedInstanceState)
    }

}



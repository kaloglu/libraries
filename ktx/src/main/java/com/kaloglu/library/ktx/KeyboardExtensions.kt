@file:JvmName("KtxKeyboardUtil")

package com.kaloglu.library.ktx

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.IntegerRes

/**
 * Utility method for showing keyboard.
 *
 * @param this@showKeyboard which has keyboard focus
 */
fun View.showKeyboard() {
    context.getInputMethodManager()
            .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Utility method for hiding keyboard.
 *
 * @param this@hideKeyboard which has keyboard focus
 */
fun View.hideKeyboard() {
    context.getInputMethodManager()
            .hideSoftInputFromWindow(windowToken, 0)
}

/**
 * Utility method for hiding keyboard if keyboard is active.
 *
 * @param this@hideActiveKeyboard which has keyboard focus
 */
fun View.hideActiveKeyboard() {
    val imm = context.getInputMethodManager()
    if (imm.isActive(this)) {
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

/**
 * Utility method for check keyboard state.
 *
 * @param this@isKeyboardShown which is current context
 */
fun Context.isKeyboardShown(): Boolean {
    return this.getInputMethodManager().isAcceptingText
}

private fun Context.getInputMethodManager() =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


/**
 * for custom action definitions
 * @param actionResId should define a integer resource
 * */
fun EditText.onActionResInSoftKeyboard(@IntegerRes actionResId: Int, onOkInSoftKeyboard: (View) -> Boolean) =
        onActionInSoftKeyboard(resources.getInteger(actionResId), onOkInSoftKeyboard)

fun EditText.onActionInSoftKeyboard(action: Int, onOkInSoftKeyboard: (View) -> Boolean) =
        setOnEditorActionListener { view, actionId, _ ->
            when (actionId) {
                action -> onOkInSoftKeyboard(view)
                else -> false
            }
        }
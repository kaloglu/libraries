@file:JvmName("KtxViewUtil")

package com.kaloglu.library.ktx

import android.animation.Animator
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator

/**
 * Created by kaloglu on 6.01.2019.
 */

@JvmOverloads
fun View.withAnimation(
        predicate: Boolean = true,
        alpha: Float? = null,
        scale: Float? = null,
        interpolator: Interpolator = LinearOutSlowInInterpolator(),
        onStart: (View) -> Unit = {},
        onEnd: (View) -> Unit = {},
        onCancel: (View) -> Unit = {},
        onRepeat: (View) -> Unit = {}
) {
    if (!predicate)
        return

    animate().apply {
        if (alpha != null) {
            alpha(alpha)
        }

        if (scale != null) {
            scaleX(scale)
            scaleY(scale)
        }

        duration = 300
        setInterpolator(interpolator)
        setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) = onStart(this@withAnimation)

            override fun onAnimationEnd(animation: Animator) = onEnd(this@withAnimation)

            override fun onAnimationCancel(animation: Animator) = onCancel(this@withAnimation)

            override fun onAnimationRepeat(animation: Animator) = onRepeat(this@withAnimation)
        })
    }.start()
}

@JvmOverloads
fun View?.show(show: Boolean = true) {
    this?.visibility = if (show) VISIBLE else GONE
}

fun View?.hide() = show(false)

fun hide(vararg views: View?) = views.forEach { it?.hide() }

@JvmOverloads
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

@JvmOverloads
inline fun <reified A : AppCompatActivity> Context.createIntent(extraBuilder: (Intent.() -> Unit) = {}) =
        Intent(this, A::class.java).apply(extraBuilder)

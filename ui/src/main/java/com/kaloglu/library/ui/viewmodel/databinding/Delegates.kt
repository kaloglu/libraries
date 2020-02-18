package com.kaloglu.library.ui.viewmodel.databinding

import com.kaloglu.library.ui.BR
import com.kaloglu.library.ui.viewmodel.databinding.interfaces.BindableField
import java.lang.reflect.Field
import kotlin.reflect.KProperty

/**
 * Create BindableDelegates for simple Viewmodel data property changes
 * */
class BindableDelegate<in R : BindableField, T : Any>(
        private var value: T,
        private var bindingTarget: Int = -1,
        private val expression: ((oldValue: T, newValue: T) -> Unit)? = null
) {
    operator fun getValue(observer: R, property: KProperty<*>): T = value

    operator fun setValue(observer: R, property: KProperty<*>, newValue: T) {
        val oldValue = value
        value = newValue
        if (bindingTarget == -1) {
            bindingTarget = BR::class.java.fields.find { field: Field ->
                field.name == property.name || "is" + field.name.capitalize() == property.name
            }
                    ?.getInt(null) ?: -1
        }
        observer.notifyPropertyChanged(bindingTarget)
        expression?.invoke(oldValue, newValue)
    }
}

/**
 *  usage
 *  (1) : var fieldName by bindable("init value")
 *
 *  (2) : var fieldName by bindable("init value", [@link #BR].fieldName)
 *
 *  (3) : var fieldName by bindable("init value"){ oldValue: FieldType, newValue: FieldType -> // doSomething... }
 *
 * @param initValue init field with this value
 * @param bindingTarget @optional trigger field value
 * @param expression @optional run after Observable.setValue like js promise
 * @return Unit
 *
 *
 * @see [] Reducing Data Binding Boilerplate With Kotlin [https://stablekernel.com/reducing-data-binding-boilerplate-with-kotlin/]
 * */
@JvmOverloads
fun <R : BindableField, T : Any> bindable(
        initValue: T,
        bindingTarget: Int = -1,
        expression: ((oldValue: T, newValue: T) -> Unit)? = null
): BindableDelegate<R, T> {
    return BindableDelegate(initValue, bindingTarget, expression)
}

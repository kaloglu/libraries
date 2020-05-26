@file:JvmName("KtxUtility")

package com.kaloglu.library.ktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.TypedValue
import com.kaloglu.library.ktx.GenericExtensions.DECIMAL_FORMAT
import com.kaloglu.library.ktx.GenericExtensions.DECIMAL_FORMAT_SYMBOLS
import com.kaloglu.library.ktx.GenericExtensions.DECIMAL_FORMAT_SYMBOLS_TR
import com.kaloglu.library.ktx.GenericExtensions.DECIMAL_FORMAT_TR
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KProperty1

object GenericExtensions {
    const val DateStringPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    const val UIDateStringPattern = "dd MMM HH:mm"

    val LOCALE_TR = Locale("tr", "TR")

    val DECIMAL_FORMAT = DecimalFormat.getInstance() as DecimalFormat
    val DECIMAL_FORMAT_SYMBOLS = DecimalFormatSymbols.getInstance()!!

    val DECIMAL_FORMAT_TR = NumberFormat.getInstance(LOCALE_TR) as DecimalFormat
    val DECIMAL_FORMAT_SYMBOLS_TR = DecimalFormatSymbols(LOCALE_TR)

    val TURKISH_CHARS = arrayOf("ş", "Ş", "ğ", "Ğ", "ı", "İ", "ü", "Ü", "ö", "Ö", "ç", "Ç")
    val NEUTRAL_CHARS = arrayOf("DateStringPattern", "S", "g", "G", "i", "I", "u", "U", "o", "CommentsCallBack", "c", "C")

}

@JvmOverloads
fun Double?.formatDecimal(decimalSeparator: Char = ',', groupingSeparator: Char = '.'): String {
    DECIMAL_FORMAT_TR.applyPattern("###.00")

    DECIMAL_FORMAT_SYMBOLS_TR.decimalSeparator = decimalSeparator
    DECIMAL_FORMAT_SYMBOLS_TR.groupingSeparator = groupingSeparator

    DECIMAL_FORMAT_TR.decimalFormatSymbols = DECIMAL_FORMAT_SYMBOLS_TR

    return DECIMAL_FORMAT_TR.format(this ?: 0.0)
}

fun Int?.formatDecimal(): String {
    DECIMAL_FORMAT_SYMBOLS.groupingSeparator = '.'
    DECIMAL_FORMAT.decimalFormatSymbols = DECIMAL_FORMAT_SYMBOLS
    return DECIMAL_FORMAT.format(this ?: 0)
}

fun Long?.formatDecimal(): String {
    DECIMAL_FORMAT_SYMBOLS.groupingSeparator = '.'
    DECIMAL_FORMAT.decimalFormatSymbols = DECIMAL_FORMAT_SYMBOLS
    return DECIMAL_FORMAT.format(this ?: 0L)
}

fun String.linefy(): String {
    if (this.isEmpty()) return this
    return this.replace(" ", "\n")
}

val String.Companion.empty: String
    get() = String()

val String.Companion.space: String
    get() = " "

fun String.Companion.join(vararg args: String?): String {
    val stringBuilder = StringBuilder()
    for (arg in args) {
        if (arg.isNullOrEmpty()) continue
        stringBuilder.append(arg)
    }
    return stringBuilder.toString()
}

fun String.Companion.join(separator: String, vararg args: String?): String {
    val stringBuilder = StringBuilder()
    for (arg in args) {
        if (arg.isNullOrEmpty()) continue
        if (stringBuilder.isNotEmpty()) stringBuilder.append(separator)
        stringBuilder.append(arg)
    }
    return stringBuilder.toString()
}

fun String?.safeGet(): String {
    return this ?: String.empty
}

fun String?.safeGet(default: String): String {
    return this ?: default
}

fun String?.isNotNullOrEmpty(): Boolean {
    return this?.let { this.isNotEmpty() } ?: false
}

fun Collection<Any>?.isNotNullOrEmpty(): Boolean {
    return this?.let { this.isNotEmpty() } ?: false
}

fun String?.safeContains(other: String, ignoreCase: Boolean = false): Boolean {
    if (this == null) return false
    return this.contains(other, ignoreCase)
}

fun String?.safeStartsWith(prefix: String, ignoreCase: Boolean = false): Boolean {
    if (this == null) return false
    return this.startsWith(prefix, ignoreCase)
}

fun Boolean?.safeGet(): Boolean {
    return this ?: false
}

fun String.toCompactHtml(): Spanned {
    @Suppress("DEPRECATION")
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }
}

fun Resources.convertDpToPixel(dp: Float): Float {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            this.displayMetrics
    )
}

inline fun <reified T, Y> List<T>.listOfProperty(property: KProperty1<T, Y?>): List<Y> {
    val listOfProperty = ArrayList<Y>()
    this.forEach { t: T ->
        val value = property.get(t)
        if (value != null)
            listOfProperty.add(value)
    }
    return listOfProperty
}

fun Int.isZero(): Boolean {
    return this == 0
}

fun Double.isZero(): Boolean {
    return this.toInt() == 0
}

fun getEventData(vararg keyValPair: Pair<String, String>): Map<String, String> {
    val hashMap = HashMap<String, String>().apply {
        keyValPair.map {
            this.put(it.first, it.second)
        }
    }

    return hashMap.toMap()
}

@JvmOverloads
inline fun <reified A : Activity> startActivity(fromActivity: Activity, extraBuilder: (Intent.() -> Unit) = {}) =
        with(fromActivity) {
            startActivity(getActivityIntent<A>(fromActivity, extraBuilder))
//            overridePendingTransition(R.anim.slide_up_animation, R.anim.scale_down_animation)
        }

@JvmOverloads
inline fun <reified A : Activity> getActivityIntent(fromContext: Context, extraBuilder: (Intent.() -> Unit) = {}) =
        Intent(fromContext, A::class.java).apply(extraBuilder)

inline fun <reified C : Any> C?.checkInjection() =
        checkNotNull(this) {
            throwProvidingError<C>()
        }

inline fun <reified C : Any> throwProvidingError(PresenterType: String = "Presenter"): String {
    val simpleClassName = C::class.java.simpleName
    val firstChar = simpleClassName.first()
    val firstCharLowerCase = simpleClassName.replaceFirst(firstChar, firstChar.toLowerCase())
    return "you should add \"$firstCharLowerCase: $simpleClassName\" to providing $PresenterType method at Module"
}

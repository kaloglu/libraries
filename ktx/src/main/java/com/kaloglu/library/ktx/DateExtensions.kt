@file:JvmName("KtxDateUtil")

package com.kaloglu.library.ktx

import com.kaloglu.library.ktx.GenericExtensions.DateStringPattern
import com.kaloglu.library.ktx.GenericExtensions.UIDateStringPattern
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun Date.isToday(): Boolean = isSameDay(Date())

fun Date.isTomorrow(): Boolean = isSameDay(Date().addDay(1))

fun Date.isSameDay(date: Date): Boolean = calendar().isSameDay(date)

fun Date.calendar(): Calendar = Calendar.getInstance().apply { time = this@calendar }

fun Calendar.isSameDay(date: Date): Boolean = isSameDay(date.calendar())

fun Calendar.isSameDay(cal: Calendar): Boolean =
    isSameYear(cal) && get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)

fun Calendar.isSameYear(cal: Calendar): Boolean = get(Calendar.YEAR) == cal.get(Calendar.YEAR)

fun Date.addDay(days: Int): Date = calendar().addDay(days).time

fun Date.addYear(years: Int): Date = calendar().addYear(years).time

fun Calendar.addDay(days: Int): Calendar {
    add(Calendar.DATE, days)
    return this
}

fun Calendar.addYear(years: Int): Calendar {
    add(Calendar.YEAR, years)
    return this
}

fun Long.getMinutes() = TimeUnit.SECONDS.toMinutes(this)

fun Long.getSeconds() = this - (this.getMinutes() * 60)

fun Date.getMonthName(locale: Locale = Locale.getDefault()) =
    calendar().getDisplayName(Calendar.MONTH, Calendar.SHORT, locale) ?: ""

fun Date.getDayOfMonth() = calendar().get(Calendar.DAY_OF_MONTH)

fun currentTimestamp() = System.currentTimeMillis()

fun String?.toTimeStamp(
    datePattern: String = DateStringPattern,
    locale: Locale = Locale.getDefault()
) = (
        this?.let { SimpleDateFormat(datePattern, locale).parse(this) }
            ?: Date()
        ).time

fun String?.toDate(
    datePattern: String = DateStringPattern,
    locale: Locale = Locale.getDefault()
) =
    this?.let { SimpleDateFormat(datePattern, locale).parse(this) }
        ?: Date()

fun Date.toDateString(
    uiPattern: String = UIDateStringPattern,
    locale: Locale = Locale.getDefault()
): String = SimpleDateFormat(uiPattern, locale).format(this)

fun String.toDateString(
    datePattern: String = DateStringPattern,
    uiPattern: String = UIDateStringPattern,
    locale: Locale = Locale.getDefault()
) = this.toDate(datePattern, locale).toDateString(uiPattern, locale = locale)

fun Long.toDateString(
    uiPattern: String = DateStringPattern,
    locale: Locale = Locale.getDefault()
) = Date(this).toDateString(uiPattern, locale)

fun Long.toDate() = Date(this)


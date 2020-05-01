@file:JvmName("KtxDateUtil")

package com.kaloglu.library.ktx

import com.kaloglu.library.ktx.GenericExtensions.DateStringPattern
import com.kaloglu.library.ktx.GenericExtensions.UI_DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*
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

fun Long.toDateTime(
    datePattern: String = DateStringPattern,
    locale: Locale = Locale.getDefault()
): String =
    SimpleDateFormat(datePattern, locale).format(Date(this))

fun currentTimeForLong() = System.currentTimeMillis()

fun Date.toFormattedDate(): String = UI_DATE_FORMAT.format(this)

fun Long.toFormattedDate() = Date(this).toFormattedDate()

fun String.toFormattedDate(locale: Locale = Locale.getDefault()) =
    SimpleDateFormat(DateStringPattern, locale).parse(this)?.toFormattedDate()

fun String.toTimeStampLong(
    dateStringPattern: String = DateStringPattern,
    locale: Locale = Locale.getDefault()
) =
    SimpleDateFormat(dateStringPattern, locale).parse(this)?.time ?: -1

fun String.toDate(datePattern: String = DateStringPattern) =
    SimpleDateFormat(datePattern, Locale.getDefault()).parse(this)


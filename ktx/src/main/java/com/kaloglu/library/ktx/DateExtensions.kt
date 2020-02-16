@file:JvmName("KtxDateUtil")

package com.kaloglu.library.ktx

import com.kaloglu.library.ktx.GenericExtensions.DateStringPattern
import com.kaloglu.library.ktx.GenericExtensions.LOCALE_TR
import com.kaloglu.library.ktx.GenericExtensions.UI_DATE_FORMAT
import java.text.ParseException
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

fun Long.getMinutes(): Long {
    return TimeUnit.SECONDS.toMinutes(this)
}

fun Long.getSeconds(): Long {
    return this - (this.getMinutes() * 60)
}

fun Date.getMonthName(): String {
    return calendar().getDisplayName(Calendar.MONTH, Calendar.SHORT, LOCALE_TR)
}

fun Date.getDayOfMonth(): Int {
    return calendar().get(Calendar.DAY_OF_MONTH)
}

@JvmOverloads
fun Long?.toDateTime(datePattern: String = DateStringPattern): String {
    if (this == null) {
        return String.empty
    }

    val date = Date(this)
    val format = SimpleDateFormat(datePattern, LOCALE_TR)
    return format.format(date)
}


fun currentTimeForLong(): Long {
    return System.currentTimeMillis()
}

fun Date.toFormattedDate(): String = UI_DATE_FORMAT.format(this)

fun Long.toFormattedDate() = Date(this).toFormattedDate()

fun String?.toFormattedDate(): String {
    if (this == null)
        return ""

    val formatter = SimpleDateFormat(DateStringPattern, LOCALE_TR)

    return formatter.parse(this).toFormattedDate()

}

@JvmOverloads
fun String?.toTimeStampLong(dateStringPattern: String = DateStringPattern): Long {
    var timeStamp: Long = -1
    if (this == null)
        return timeStamp

    try {
        timeStamp = SimpleDateFormat(dateStringPattern, LOCALE_TR).parse(this).time
    } catch (e: ParseException) {
        e.printStackTrace()
    } finally {
        return timeStamp
    }
}


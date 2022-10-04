package vn.gst.sun.lib

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val yyyyMMddFormat = "yyyy-MM-dd"
    private const val ddMMMYYYYFormat = "dd MMM yyyy"

    fun formatToDDMMMYYYY(inputDate: String): String {
        val inputFormat: DateFormat = SimpleDateFormat(yyyyMMddFormat, Locale.US)
        val outputFormat: DateFormat = SimpleDateFormat(ddMMMYYYYFormat, Locale.US)
        val date: Date = inputFormat.parse(inputDate)

        return outputFormat.format(date)
    }

    fun getYear(inputDate: String): Int {
        val inputFormat: DateFormat = SimpleDateFormat(yyyyMMddFormat, Locale.US)
        val cal = Calendar.getInstance()
        cal.time = inputFormat.parse(inputDate)
        return cal.get(Calendar.YEAR)
    }
}
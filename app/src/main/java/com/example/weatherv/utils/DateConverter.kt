package com.example.weatherv.utils

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {



    fun toDate(s: String): String? {
        return try {
            val sdf = SimpleDateFormat("EEEE, dd MMMM", Locale.ENGLISH)
            val netDate = Date(s.toLong() * 1000)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    fun toHour(s: String): String? {
        return try {
            val sdf = SimpleDateFormat("hh a", Locale.ENGLISH)
            val netDate = Date(s.toLong() * 1000)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }
}
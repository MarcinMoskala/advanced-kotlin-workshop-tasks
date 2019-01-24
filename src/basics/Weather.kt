package basics

import java.awt.*

import java.awt.Color.*

class Weather {

    fun updateWeather(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> "cold" to BLUE
            degrees < 23 -> "mild" to ORANGE
            else -> "hot" to RED
        }
        // ...
    }
}
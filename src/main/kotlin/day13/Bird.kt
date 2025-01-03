package org.example.day13

import kotlinx.coroutines.delay

class Bird(val sound: String, val soundDelay: Long) {

    suspend fun singShort() {
        repeat(SHORT_SING_COUNT) {
            println(sound)
            delay(soundDelay)
        }
    }

    suspend fun singAllDay() {
        while (true) {
            println(sound)
            delay(soundDelay)
        }
    }

    companion object {
        const val SHORT_SING_COUNT = 4
    }
}
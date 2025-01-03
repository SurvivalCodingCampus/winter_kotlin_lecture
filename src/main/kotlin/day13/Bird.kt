package org.example.day13

import kotlinx.coroutines.delay

class Bird(val sound: String, val soundDelay: Long) {
    var count = 0
        private set

    suspend fun singFourTimes() {
        repeat(4) {
            println(sound)
            delay(soundDelay)
            count++
        }
    }
}
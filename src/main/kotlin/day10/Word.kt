package org.example.day10

class Word(var word: String) {

    fun isVowel(i: Int): Boolean {
        return when (word.lowercase().substring(i, i + 1)) {
            "a", "e", "i", "o", "u" -> true
            else -> false
        }
    }

    fun isConsonant(i: Int): Boolean {
        return when (word.lowercase().substring(i, i + 1)) {
            "a", "e", "i", "o", "u" -> false
            else -> true
        }
    }

    fun getLength() = word.length
}
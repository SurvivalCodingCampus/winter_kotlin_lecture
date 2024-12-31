package org.example.day10

class Word(var word: String) {

    private val vowel = arrayOf<String>("a", "e", "i", "o", "u")

    fun isVowel(i: Int): Boolean {
        return vowel.contains(word[i].lowercase())
    }

    fun isConsonant(i: Int): Boolean {
        return !isVowel(i)
    }
}
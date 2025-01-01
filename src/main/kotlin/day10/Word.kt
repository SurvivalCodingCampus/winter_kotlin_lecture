package org.hyunjung.day10

class Word(var word: String) {
    fun isVowel(i: Int) = i in word.indices && word[i] in "aeiouAEIOU"

    fun isConsonant(i: Int) = i in word.indices && word[i] !in "aeiouAEIOU" && word[i].isLetter()
}
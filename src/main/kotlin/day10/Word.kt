package org.example.day10


class Word(private var word: String) {

    private val vowelCheckList = listOf("a", "e", "i", "o", "u")

    fun isVowel(i: Int): Boolean {
        if (i < 0 || i >= word.length) {
            throw Exception("글자 길이를 확인 해 주세요")
        }
        return vowelCheckList.contains(word.trim().lowercase().substring(i, i + 1))
    }

    fun isConsonant(i: Int): Boolean {
        if (i < 0 || i >= word.length) {
            throw Exception("글자 길이를 확인 해 주세요")
        }
        return !vowelCheckList.contains(word.trim().lowercase().substring(i, i + 1))
    }
}

package org.example.day10

class Word(
    var word: String
) {
    private val isVowel = BooleanArray(26)

    init {
        "aeiou".forEach {
            isVowel[it.code - 'a'.code] = true
        }
    }

    private fun isLetter(index: Int): Boolean = word[index].isLetter()
    private fun getCode(index: Int): Int = word.lowercase()[index].code - 'a'.code

    fun isVowel(index: Int): Boolean = isLetter(index) && isVowel[getCode(index)]

    fun isConsonant(index: Int): Boolean =
        isLetter(index) && !isVowel[getCode(index)]

}
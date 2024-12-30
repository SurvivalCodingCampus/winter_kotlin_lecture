package day10


class Word(val word: String) {
    init {
        require(word.isNotEmpty())
        require(word.matches("[a-zA-Z]+".toRegex()))
    }

    fun isVowel(i: Int): Boolean = "aeiou".contains(word[i])
    fun isConsonant(i: Int) = !isVowel(i)
}
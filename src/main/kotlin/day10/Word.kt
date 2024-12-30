package day10

class Word(var word: String) {
    fun isVowel(i: Int): Boolean {
        return when(word.substring(i, i + 1)) {
            in listOf("A", "a", "E", "e", "I", "i", "O", "o", "U", "u") -> true
            else -> false
        }
    }

    fun isConsonant(i: Int): Boolean {
        return !isVowel(i)
    }
}
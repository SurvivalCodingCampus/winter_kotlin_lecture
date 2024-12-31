package day10.exercise

class Word(
    private var word: String
) {

    // 모음 판단
    fun isBowel(i: Int): Boolean {
        return word.lowercase()[i] in CHECK_WORD
    }

    // 자음 판단
    fun isConsonant(i: Int): Boolean {
        return word.lowercase()[i] !in CHECK_WORD
    }

    companion object {
        const val CHECK_WORD = "aeiou"
    }
}

fun main() {
    val word = Word("E")
    println(word.isBowel(0))


}
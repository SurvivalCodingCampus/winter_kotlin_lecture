package day10.exercise

class Word(
    private var word: String
) {

    // 모음 리스트
    private val list = listOf("a", "e", "i", "o", "u")

    // 모음 판단
    fun isBowel(i: Int): Boolean {
        require(i <= word.length - 1) { ERROR_MESSAGE }
        return list.contains(word.substring(i, i + 1).lowercase())
    }

    // 자음 판단
    fun isConsonant(i: Int): Boolean {
        require(i <= word.length - 1) { ERROR_MESSAGE }
        return !list.contains(word.substring(i, i + 1).lowercase())
    }

    companion object {
        const val ERROR_MESSAGE = "Index 초과 입니다."
    }

}

fun main() {
    val word = Word("Test")
    println(word.isBowel(0))
    println(word.isBowel(1))
    println(word.isBowel(2))
    println(word.isBowel(3))
    println(word.isBowel(4))
}
package day10
/*
실습1. i 번째 글자가 모음인지 알려주는 isVowel() 함수를 완성하시오
영어에서의 모음은 a, e, i, o, u 다섯가지이다

실습2. i 번째 글자가 자음인지 알려주는 isConsonant() 함수를 완성하시오
*/

class Word(var word: String) {

    fun isVowel(i: Int): Boolean {
        if (i !in word.indices) {
            throw IndexOutOfBoundsException("범위를 벗어났습니다")
        }
        val char = word.substring(i, i + 1).lowercase()
        return char in "aeiou"
    }

    fun isConsonant(i: Int): Boolean {
        if (i !in word.indices) {
            throw IndexOutOfBoundsException("범위를 벗어났습니다")
        }
        val char = word.substring(i, i + 1).lowercase()
        return char in "bcdfghjklmnpqrstvwxyz"
    }
}

package day10

import org.junit.Test

import org.junit.Assert.*

class WordTest {

    @Test
    fun isVowel() {
        // 소문자 테스트
        val word1: Word = Word("apple")
        assertEquals(true, word1.isVowel(0))

        // 대문자 테스트
        val word2: Word = Word("Apple")
        assertEquals(true, word2.isVowel(0))

        // 다른 모음 테스트
        val word3: Word = Word("Internet")
        assertEquals(true, word3.isVowel(0))

        val word4: Word = Word("orange")
        assertEquals(true, word4.isVowel(0))

        val word5: Word = Word("make")
        assertEquals(true, word5.isVowel(3))
    }

    @Test
    fun isConsonant() {
        val word: Word = Word("hello")
        assertEquals(true, word.isConsonant(0))
    }
}
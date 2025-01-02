package day10

import org.junit.Test

import org.junit.Assert.*

class WordTest {

    @Test
    fun checkIsVowel() {
        val word = Word("HELLO")
        assertEquals(false, word.isVowel(0))
        assertEquals(true, word.isVowel(1))
//        assertEquals(false, word.isVowel(-1))
    }

    @Test
    fun checkIsConsonant() {
        val word = Word("HELLO")
        assertEquals(true, word.isConsonant(2))
        assertEquals(false, word.isConsonant(4))
//        assertEquals(false, word.isConsonant(10))
    }
}
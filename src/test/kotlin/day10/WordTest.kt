package day10

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

class WordTest {

    @Test
    fun checkIsVowel() {
        val word = Word("HELLO")
        assertEquals(false, word.isVowel(0))
        assertEquals(true, word.isVowel(1))
        assertThrows<IndexOutOfBoundsException> { word.isVowel(-1) }
    }

    @Test
    fun checkIsConsonant() {
        val word = Word("HELLO")
        assertEquals(true, word.isConsonant(2))
        assertEquals(false, word.isConsonant(4))
        assertThrows<IndexOutOfBoundsException> { word.isConsonant(10) }
    }
}
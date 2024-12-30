package day10

import org.example.day10.Word
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WordTest() {
    private val word = Word("ApPle^^2")

    @Before
    fun setUp() {

    }

    @Test
    fun `isVowel() test`() {
        assertTrue(word.isVowel(0))
        assertTrue(word.isVowel(4))
        assertFalse(word.isVowel(5))
    }

    @Test
    fun `isConsonant() test`() {
        assertTrue(word.isConsonant(1))
        assertTrue(word.isConsonant(2))
        assertFalse(word.isConsonant(6))
    }
}
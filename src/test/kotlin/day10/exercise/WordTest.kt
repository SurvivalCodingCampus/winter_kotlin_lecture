package day10.exercise

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class WordTest {

    @Test
    fun `모음 판단 테스트 `() {
        val word = Word("Test")

        assertEquals(false, word.isBowel(0))
        assertEquals(true, word.isBowel(1))
        assertEquals(false, word.isBowel(2))
        assertEquals(false, word.isBowel(3))

    }

    @Test
    fun `자음 판단 테스트 `() {
        val word = Word("Test")

        assertEquals(true, word.isConsonant(0))
        assertEquals(false, word.isConsonant(1))
        assertEquals(true, word.isConsonant(2))
        assertEquals(true, word.isConsonant(3))

    }
}


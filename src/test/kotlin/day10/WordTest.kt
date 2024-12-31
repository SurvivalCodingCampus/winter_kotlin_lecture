package day10

import org.example.day10.Word
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class WordTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `자음인지 알려주는 isVowel() 테스트`() {
        val word = Word("Apple")

        for (i: Int in 0..<word.getLength()) {
            when (i) {
                0, 4 -> assertEquals(true, word.isVowel(i))
                else -> assertEquals(false, word.isVowel(i))
            }
        }
    }

    @Test
    fun `모음인지 알려주는 isConsonant() 테스트`() {
        val word = Word("Apple")

        for (i: Int in 0..<word.getLength()) {
            when (i) {
                1, 2, 3 -> assertEquals(true, word.isConsonant(i))
                else -> assertEquals(false, word.isConsonant(i))
            }
        }
    }
}
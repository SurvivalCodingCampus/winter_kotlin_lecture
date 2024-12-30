package day10

import org.example.day10.Word
import org.junit.Assert.*
import kotlin.test.Test

class WordTest {

    /// a-z 사이의 모든 모음
    private val aToZVowel = "aeiou"
    /// a-z 사이의 모든 자음
    private val aToZConsonant = "bcdfghjklmnpqrstvwxyz"

    @Test
    fun isVowel() {
        val vowelWord = Word(aToZVowel)
        for (i in 0 until aToZVowel.length) {
            assertTrue(vowelWord.isVowel(i))
        }

        val consonantWord = Word(aToZConsonant)

        for (i in 0 until aToZConsonant.length) {
            assertFalse(consonantWord.isVowel(i))
        }

    }

    @Test
    fun isConsonant() {
        val vowelWord = Word(aToZVowel)
        for (i in 0 until aToZVowel.length) {
            assertFalse(vowelWord.isConsonant(i))
        }

        val consonantWord = Word(aToZConsonant)

        for (i in 0 until aToZConsonant.length) {
            assertTrue(consonantWord.isConsonant(i))
        }
    }

}
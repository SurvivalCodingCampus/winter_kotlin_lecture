package day10

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WordTest {

    @Test
    fun `대소문자 구분 없이 모음 판별 가능`() {
        val testWord = Word("Hello Aiu")
        assertEquals(true, testWord.isVowel(6))  // A
        assertEquals(true, testWord.isVowel(1)) // e
        assertEquals(true, testWord.isVowel(7)) // i
        assertEquals(true, testWord.isVowel(4)) // o
        assertEquals(true, testWord.isVowel(8)) // u
        assertEquals(false, testWord.isVowel(0)) // H
    }

    @Test
    fun `대소문자 구분 없이 자음 판별 가능`() {
        val testWord = Word("AaBbcdefghijklmnopqrstuvwxyz")

        for (i in testWord.word.indices) {
            val char = testWord.word.substring(i, i + 1).lowercase()

            val expectedResult = char in "bcdfghjklmnpqrstvwxyz"
            val result = testWord.isConsonant(i)

            assertEquals(expectedResult, result)
        }
    }

    @Test
    fun `모음 판별 인덱스가 범위를 벗어나면 예외 발생`() {
        val testWord = Word("hello")

        assertFailsWith<IndexOutOfBoundsException> {
            testWord.isVowel(10)
        }
    }

    @Test
    fun `자음 판별 인덱스가 범위를 벗어나면 예외 발생`() {
        val testWord = Word("hello")

        assertFailsWith<IndexOutOfBoundsException> {
            testWord.isConsonant(10)
        }
    }
}
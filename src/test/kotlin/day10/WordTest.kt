package day10

import org.hyunjung.day10.Word
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WordTest {

    private lateinit var word: Word
    private lateinit var emptyWord: Word
    private lateinit var singleWord: Word

    @Before
    fun setUp() {
        word = Word("Hello!")
        emptyWord = Word("")
        singleWord = Word("A")
    }

    @Test
    fun `모음인 경우`() {
        assertTrue(word.isVowel(1))
        assertFalse(word.isConsonant(1))
    }

    @Test
    fun `자음인 경우`() {
        assertFalse(word.isVowel(0))
        assertTrue(word.isConsonant(0))
    }

    @Test
    fun `특수 문자인 경우`() {
        assertFalse(word.isVowel(5))
        assertFalse(word.isConsonant(5))
    }

    @Test
    fun `i가 인덱스를 초과한 경우`() {
        assertFalse(word.isVowel(100))
        assertFalse(word.isConsonant(100))
    }

    @Test
    fun `빈 문자열인 경우`() {
        assertFalse(emptyWord.isVowel(0))
        assertFalse(emptyWord.isConsonant(0))
    }

    @Test
    fun `단일 문자인 경우`() {
        assertTrue(singleWord.isVowel(0))
        assertFalse(singleWord.isConsonant(0))
    }
}
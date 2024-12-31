package day10

import org.example.day10.Word
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

class WordTest {

    @Test
    fun `isVowel - 대소문자 체크 Word(Apple), Word(apple) 일 때, isVowel(0)은 모두 true가 되어야 한다`() {
        var word = Word("Apple")
        assertEquals(word.isVowel(0), true)

        word = Word("apple")
        assertEquals(word.isVowel(0), true)
    }

    @Test
    fun `isVowel - 모음 체크 Word(apple) 일 때, isVowel(0)은 true, isVowel(1)은 false가 되어야 한다`() {
        val word = Word("apple")
        assertEquals(word.isVowel(0), true)
        assertEquals(word.isVowel(1), false)
    }

    @Test
    fun `isVowel - 문자열 길이 체크 Word(apple) 일 때, isVowel(5)를 하면 "글자 길이를 확인 해 주세요" Exception이 발생한다`() {
        val word = Word("apple")
        val exception = assertThrows<Exception> {
            word.isVowel(5)
        }
        assertEquals("글자 길이를 확인 해 주세요", exception.message)
    }

    @Test
    fun `isConsonant - 대소문자 체크 Word(Kotlin), Word(kotlin) 일 때, isConsonant(0)은 모두 true가 되어야 한다`() {
        var word = Word("Kotlin")
        assertEquals(word.isConsonant(0), true)

        word = Word("kotlin")
        assertEquals(word.isConsonant(0), true)
    }

    @Test
    fun `isConsonant - 문자열 길이 체크 Word(apple) 일 때, isConsonant(5)를 하면 "글자 길이를 확인 해 주세요" Exception이 발생한다`() {
        val word = Word("apple")
        val exception = assertThrows<Exception> {
            word.isConsonant(5)
        }
        assertEquals("글자 길이를 확인 해 주세요", exception.message)
    }
}
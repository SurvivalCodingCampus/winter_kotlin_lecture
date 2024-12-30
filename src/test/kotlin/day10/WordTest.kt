package day10

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class WordTest {
    @Test
    fun `instantiate fails`() {
        val failingDataset = arrayOf("", "    ", "asdf asdf", "sdf23")
        failingDataset.forEach {
            assertThrows(IllegalArgumentException::class.java) { Word(it) }
        }
    }

    @Test
    fun `check for vowels`() {
        val results = arrayOf(
            "apple" to 3,
            "Target" to 1,
            "imaGinE" to 2,
            "dvd" to 0,
        ).map { Word(it.first).isVowel(it.second) }
        val expected = arrayOf(false, true, true, false)
        expected.zip(results).forEach {
            assertEquals(it.first, it.second)
        }
    }
}
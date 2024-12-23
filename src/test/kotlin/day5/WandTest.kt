package day5

import org.junit.Assert.assertThrows
import org.junit.Test

class WandTest {

    @Test
    fun `initialization safety checks`() {
        assertThrows("name should be longer than 3", IllegalArgumentException::class.java) { Wand("a", 10.0) }
        assertThrows("power should be in range", IllegalArgumentException::class.java) { Wand("abc", -1.0) }
    }

    @Test
    fun `setter safety checks`() {
        val testWand = Wand("abc", 10.0)

        assertThrows("name should be longer than 3", IllegalArgumentException::class.java) { testWand.name = "a" }
        assertThrows("power should be in range", IllegalArgumentException::class.java) { testWand.power = -1.0 }
    }
}
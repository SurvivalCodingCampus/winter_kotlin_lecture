package day05

import org.hyunjung.day05.Wand
import org.junit.Assert.*
import org.junit.Test

class WandTest {

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이 이름이 null이거나 3문자 미만이면 예외 발생`() {
        Wand(name = "", power = 10.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이 이름이 3문자 미만이면 예외 발생`() {
        Wand(name = "불", power = 10.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이 마력이 0_5 미만이면 예외 발생`() {
        Wand(name = "불의 지팡이", power = 0.4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이 마력이 100_0 초과이면 예외 발생`() {
        Wand(name = "불의 지팡이", power = 150.0)
    }

    @Test
    fun `정상적인 지팡이 생성`() {
        val wand = Wand(name = "불의 지팡이", power = 50.0)
        assertEquals("불의 지팡이", wand.name)
        assertEquals(50.0, wand.power, 0.0)
    }
}
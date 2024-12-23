package day05

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals

class WandTest {

    @Test
    fun `지팡이 생성자 유효성 검사`() {
        val wand = Wand("마법지팡이", 10.0)
        assertEquals("마법지팡이", wand.name)
        assertEquals(10.0, wand.power)
    }

    @Test
    fun `지팡이 이름이 3글자 미만시 오류 발생`() {
        assertFailsWith<IllegalArgumentException> {
            Wand("지팡", 10.0)
        }
    }

    @Test
    fun `지팡이 마력 조건 미만시 오류 발생`() {
        assertFailsWith<IllegalArgumentException> {
            Wand("마법지팡이", 0.4)
        }
    }

    @Test
    fun `지팡이 마력 100 초과시 오류 발생`() {
        assertFailsWith<IllegalArgumentException> {
            Wand("마법지팡이", 110.0)
        }
    }

}
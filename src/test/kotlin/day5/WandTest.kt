package day5

import org.example.day5.Wand
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class WandTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `지팡이 이름은 null 일 수 없고, 반드시 3문자 이상`() {
        // 지팡이 이름이 3글자 미만
        assertThrows(IllegalArgumentException::class.java) {
            var wand = Wand("지팡")
        }

        // 지팡이 이름을 혹시라도 문자 "null"이라고 지은 경우
        assertThrows(IllegalArgumentException::class.java) {
            var wand = Wand("null")
        }
    }

    @Test
    fun `지팡이의 마력 설정 테스트`() {
        // 마력이 0.5 ~ 100.0 범위 밖인 경우
        assertThrows(IllegalArgumentException::class.java){
            var wand = Wand("지팡이", power = 0.0)
        }

        // 마력이 0.5 ~ 100.0 범위 안인 경우
        var wand = Wand("지팡이", power = 10.0)
        assertEquals(true, 10.0 == wand.power)
    }
}
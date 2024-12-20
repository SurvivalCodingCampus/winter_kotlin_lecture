package day5

import org.example.day5.Wand
import org.example.day5.Wizard
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import kotlin.test.assertEquals

class WizardTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `마법사 이름은 null 일 수 없고, 반드시 3문자 이상`() {
        // 마법사 이름이 3글자 미만
        assertThrows(IllegalArgumentException::class.java) {
            var wand = Wand("지팡")
        }

        // 마법사 이름을 혹시라도 문자 "null"이라고 지은 경우
        assertThrows(IllegalArgumentException::class.java) {
            var wand = Wand("null")
        }
    }

    @Test
    fun `마법사의 지팡이는 null일 수 없다`() {
        assertThrows(IllegalArgumentException::class.java) {
            var wizard = Wizard("제이나", hp = 50, wand = null)
        }
    }

    @Test
    fun `마법사의 MP는 0 이상이어야 한다`() {
        // 마법사의 MP는 0 미만인 경우
        var wand1 = Wand("지팡이", power = 50.0)
        var wizard = Wizard("제이나", hp = 50, wand = wand1)
        assertThrows(IllegalArgumentException::class.java) {
            wizard.mp = -1
        }

        // 마법사의 MP는 0 이상인 경우
        wizard.mp = 100
        assertEquals(100, wizard.mp)
    }
}
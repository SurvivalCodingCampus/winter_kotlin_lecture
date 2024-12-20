package day5

import org.example.day5.Wand
import org.example.day5.Wizard
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Before

import org.junit.Test

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
        assertThrows(IllegalArgumentException::class.java){
            var wizard = Wizard("제이나", hp = 50, wand = null)
        }
    }
}
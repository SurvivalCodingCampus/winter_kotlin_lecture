package day05

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals

class WizardTest {

    @Test
    fun `마법사 생성자 유효성 검사`() {
        val wand = Wand("마법지팡이", 10.0)
        val wizard = Wizard("해리포터", 100, 50, wand)
        assertEquals("해리포터", wizard.name)
        assertEquals(100, wizard.hp)
        assertEquals(50, wizard.mp)
        assertEquals(wand, wizard.wand)
    }

    @Test
    fun `마법사 이름이 3글자 미만시 오류 발생`() {
        val wand = Wand("마법지팡이", 10.0)
        assertFailsWith<IllegalArgumentException> {
            Wizard("해리", 100, 50, wand)
        }
    }

    @Test
    fun `마법사 hp 0 미만시 0으로 셋팅`() {
        val wand = Wand("마법지팡이", 10.0)
        val wizard = Wizard("해리포터", -10, 50, wand)
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `마법사 mp 0 미만시 오류 발생`() {
        val wand = Wand("마법지팡이", 10.0)
        assertFailsWith<IllegalArgumentException> {
            Wizard("해리포터", 100, -50, wand)
        }
    }
    
}
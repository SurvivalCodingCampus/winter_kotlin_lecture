package day05

import day03.Hero
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals

class WizardTest {

    @Test
    fun `Unit의 hp 20 회복시 mp 10 소모됨 확인`() {
        val wand = Wand("마법지팡이", 10.0)
        val wizard = Wizard("해리포터", 100, 10, wand)
        val hero = Hero("용사", 50)
        wizard.heal(hero)
        assertEquals(0, wizard.mp)
        assertEquals(70, hero.hp)
    }

    @Test
    fun `mp 부족시 hp 회복시키지 않고 mp 마이너스 되지 않음 확인`() {
        val wand = Wand("마법지팡이", 10.0)
        val wizard = Wizard("해리포터", 100, 5, wand)
        val hero = Hero("용사", 50)
        wizard.heal(hero)
        assertEquals(5, wizard.mp)
        assertEquals(50, hero.hp)
    }

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
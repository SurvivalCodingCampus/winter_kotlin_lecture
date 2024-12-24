package day06

import day03.Hero
import day05.Wand
import kotlin.test.Test
import kotlin.test.assertEquals

class GreatWizardTest {

    @Test
    fun `Unit의 hp 전부 회복시 mp 50 소모됨 확인`() {
        val gWizard = GreatWizard("해리포터", 100, 150, wand = Wand("마법지팡이", 10.0))
        val hero = Hero("용사", 50)
        gWizard.heal(hero)
        assertEquals(100, gWizard.mp)
        assertEquals(Hero.MAX_HP, hero.hp)
    }

    @Test
    fun `mp 부족시 hp 회복시키지 않고 mp 마이너스 되지 않음 확인`() {
        val gWizard = GreatWizard("해리포터", 100, 40, wand = Wand("마법지팡이", 10.0))
        val hero = Hero("용사", 50)
        gWizard.heal(hero)
        assertEquals(40, gWizard.mp)
        assertEquals(50, hero.hp)
    }

}
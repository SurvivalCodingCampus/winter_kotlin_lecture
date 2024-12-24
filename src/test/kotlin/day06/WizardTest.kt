package day06

import org.example.day06.Hero
import org.example.day06.Wand
import org.example.day06.Wizard
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var wizard: Wizard

    @Before
    fun setUp() {
        wizard = Wizard(
            name = "불마법사",
            wand = Wand("불 지팡이", 20.0)
        )
    }

    @Test
    fun `heal 테스트`() {
        val hero = Hero("김탱커")
        hero.reduceHp(100)
        assertEquals(0, hero.hp)
        wizard.heal(hero)
        assertEquals(Wizard.SKILL_HEAL_RECOVERY_POINTS, hero.hp)
    }
}
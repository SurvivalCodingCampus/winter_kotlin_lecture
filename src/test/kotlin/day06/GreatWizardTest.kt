package day06

import org.example.day06.GreatWizard
import org.example.day06.Hero
import org.example.day06.Wand
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GreatWizardTest {
    private lateinit var greatWizard: GreatWizard

    @Before
    fun setUp() {
        greatWizard = GreatWizard(
            name = "위대한 마법사",
            wand = Wand("위대한 완드", 50.0)
        )
    }

    @Test
    fun `superHeal 테스트`() {
        val hero = Hero("김탱커")
        hero.reduceHp(100)
        assertEquals(0, hero.hp)
        greatWizard.superHeal(hero)
        assertEquals(hero.maxMp, hero.hp)
    }
}
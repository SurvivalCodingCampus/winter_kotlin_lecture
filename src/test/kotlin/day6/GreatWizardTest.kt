package day6

import day3.Hero
import org.junit.Assert.assertEquals
import org.junit.Test

class GreatWizardTest {

    @Test
    fun `superHeal should restore Hero hp`() {
        val injuredHero = Hero("Injured", 10).apply { this.hp.maximum += 30 }
        val testWizard = GreatWizard("abc")
        testWizard.superHeal(injuredHero)
        assertEquals(injuredHero.hp.maximum, injuredHero.hp.value);
    }
}
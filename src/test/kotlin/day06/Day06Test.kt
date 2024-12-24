package day06

import day06.Slime.Companion.SLIME_DAMAGE
import org.example.day03.Cleric
import org.example.day03.GreatWizard
import org.example.day03.GreatWizard.Companion.GREAT_WIZARD_MAX_MP
import org.example.day03.GreatWizard.Companion.USE_SUPER_HEAL_MP
import org.example.day03.MAX_HP
import org.example.day03.Wizard
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll


class GreatWizardTest {
    companion object {
        const val DAMAGE = 30
    }

    @Test
    fun `Great Wizard Test`(): Unit = assertAll(
        "Great Wizard super heal test",
        {
            val greatWizard = GreatWizard(name = "위대한위자드", wand = null)
            val cleric = Cleric(name = "Cleric", hp = MAX_HP - DAMAGE)

            assertEquals(GREAT_WIZARD_MAX_MP, greatWizard.mp)

            greatWizard.superHeal(cleric)

            assertEquals(MAX_HP, cleric.hp)
            assertEquals(GREAT_WIZARD_MAX_MP - USE_SUPER_HEAL_MP, greatWizard.mp)
        },
    )

}


class SlimeTest {
    companion object {
        const val WIZARD_HP = 100
        const val WIZARD_MP = 100
    }

    @Test
    fun `Slime Test`(): Unit = assertAll(
        "basic attack damage test ($SLIME_DAMAGE)",
        {
            val wizard = Wizard(name = "위자드", hp = WIZARD_HP, mp = WIZARD_MP)
            val greenSlime = Slime("초록색")


            greenSlime.attack(wizard)

            assertEquals(WIZARD_HP - SLIME_DAMAGE, wizard.hp)
            println("-------done Test #1------")
        },
        {
            val wizard = Wizard(name = "위자드", hp = WIZARD_HP, mp = WIZARD_MP)
            val redSlime = PoisonSlim("빨강색")

            redSlime.attack(wizard)

            assertEquals(72, wizard.hp)
            println("-------done Test #2------")

        },
        {
            val wizard = Wizard(name = "위자드", hp = WIZARD_HP, mp = WIZARD_MP)
            val redSlime = PoisonSlim("빨강색")

            for (i in 0..5) {
                redSlime.attack(wizard)
            }

            assertEquals(0, wizard.hp)
            println("-------done Test #3------")

        },
    )
}


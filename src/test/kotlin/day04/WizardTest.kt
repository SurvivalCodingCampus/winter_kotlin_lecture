package day04

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard
import org.example.day05.Wand

import org.junit.jupiter.api.assertThrows

class WizardTest {
    lateinit var hero: Hero
    lateinit var wizard: Wizard

    @Before
    fun setUp() {
        hero = Hero("hero",5, Sword("common sword", 5))
        wizard = Wizard("wizard", 10, 5, 5, Wand("common wand", 5.0))
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `heal function test`() {
        wizard.heal(hero)

        assertEquals(10, hero.hp)   // 정상적으로 회복 기능이 작동하는지 확인

        // 회복시키려는 대상의 hp가 최대일 때
        val heroMaxHp = Hero("heroMaxHp")
        wizard.heal(heroMaxHp)
        assertEquals(Hero.MAX_HP, heroMaxHp.hp)

        // wizard의 mp가 부족할 때
        val wizardWithLowMp = Wizard("wizardWithLowMp", 40, 2, 5, Wand("common wand", 5.0))
        val heroHpBeforeHealed = hero.hp
        wizardWithLowMp.heal(hero)
        assertEquals(heroHpBeforeHealed, hero.hp)
    }

    @Test
    fun `test wizard properties after construction`() {

        // test for hp is negative
        val wizard = Wizard("common wizard", -5, 10, 10, Wand("common", 5.0))
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `wizardConstructionNameIsNUll`() {
        // test for name is null
        /*try {
            val wizard = Wizard(null, 10, 10, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }*/
        assertThrows<IllegalArgumentException>("name is null") {
            Wizard(null, 10, 10, 5, Wand("common wand", 5.0))
        }
    }

    @Test
    fun `wizardConstructionNameIsTooShort`() {
        // test for name is too short
        /*try {
            val wizard = Wizard("?", 10, 10, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }*/
        assertThrows<IllegalArgumentException>("name is too short") {
            Wizard("?", 10, 10, 5, Wand("common wand", 5.0))
        }
    }

    @Test
    fun `wizardConstructionWandIsNull`() {
        // test for wand is null
        /*try {
            val wizard = Wizard(null, 10, 10, 5, null)
        } catch(e: IllegalArgumentException) {
            println("wand is null")
        }*/
        assertThrows<IllegalArgumentException>("wand is null") {
            Wizard("common wizard", 10, 10, 5, null)
        }
    }

    @Test
    fun `wizardConstructionMpIsNegative`() {
        // test for mp is negative
        /*try {
            val wizard = Wizard(null, 10, -5, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("mp is negative")
        }*/
        assertThrows<IllegalArgumentException>("mp is negative") {
            Wizard("common wizard", 10, -5, 5, Wand("common wand", 5.0))
        }
    }

    @Test
    fun `wizerdAfterNameIsNull`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        /*try {
            wizardAfter.name = null
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }*/
        assertThrows<IllegalArgumentException>("name is null") {
            wizardAfter.name = null
        }
    }

    @Test
    fun `wizardAfterNameIsTooShort`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        /*try {
            wizardAfter.name = "?"
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }*/
        assertThrows<IllegalArgumentException>("name is too short") {
            wizardAfter.name = "?"
        }
    }

    @Test
    fun `wizardAfterWandIsNULL`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        /*try {
            wizardAfter.wand = null
        } catch(e: IllegalArgumentException) {
            println("wand is null")
        }*/
        assertThrows<IllegalArgumentException>("wand is null") {
            wizardAfter.wand = null
        }
    }

    @Test
    fun `wizardAfterMpIsNegative`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        /*try {
            wizardAfter.mp = -5
        } catch(e: IllegalArgumentException) {
            println("mp is negative")
        }*/
        assertThrows<IllegalArgumentException>("mp is negative") {
            wizardAfter.mp = -5
        }
    }

    @Test
    fun `common heal`() {
        val wizard = Wizard("common wizard", 10, 15, 10, Wand("common wand", 5.0))
        val hero = Hero("common hero", 5, null)

        wizard.heal(hero)

        assertEquals(wizard.healAbility + 5, hero.hp)
        assertEquals(5, wizard.mp)
    }

    @Test
    fun `out of mp for heal`() {
        val wizard = Wizard("common wizard", 10, 30, 10, Wand("common wand", 5.0))
        val hero = Hero("common hero", 5, null)

        for(i in 1..5) {
            wizard.heal(hero)
        }

        assertEquals(35, hero.hp)
        assertEquals(0, wizard.mp)
    }
}
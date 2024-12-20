package day04

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard
import org.example.day05.Wand

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
        //assertEquals(0, wizard.hp)
        // 어차피 위의 것들은 init 블록이나 보조생성자로 getter, setter를 잡아써야 한다.

    }

    @Test
    fun `wizardConstructionNameIsNUll`() {
        // test for name is null
        try {
            val wizard = Wizard(null, 10, 10, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }
    }

    @Test
    fun `wizardConstructionNameIsTooShort`() {
        // test for name is too short
        try {
            val wizard = Wizard("?", 10, 10, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }
    }

    @Test
    fun `wizardConstructionWandIsNull`() {
        // test for wand is null
        try {
            val wizard = Wizard(null, 10, 10, 5, null)
        } catch(e: IllegalArgumentException) {
            println("wand is null")
        }
    }

    @Test
    fun `wizardConstructionMpIsNegative`() {
        // test for mp is negative
        try {
            val wizard = Wizard(null, 10, -5, 5, Wand("common wand", 5.0))
        } catch(e: IllegalArgumentException) {
            println("mp is negative")
        }
    }

    @Test
    fun `wizerdAfterNameIsNull`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        try {
            wizardAfter.name = null
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }
    }

    @Test
    fun `wizardAfterNameIsTooShort`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        try {
            wizardAfter.name = "?"
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }
    }

    @Test
    fun `wizardAfterWandIsNULL`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        try {
            wizardAfter.wand = null
        } catch(e: IllegalArgumentException) {
            println("wand is null")
        }
    }

    @Test
    fun `wizardAfterMpIsNegative`() {
        val wizardAfter = Wizard("common wizard", 10, 10, 10, Wand("common", 5.0))

        try {
            wizardAfter.mp = -5
        } catch(e: IllegalArgumentException) {
            println("mp is negative")
        }
    }
}
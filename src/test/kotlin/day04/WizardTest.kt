package day04

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard

class WizardTest {
    lateinit var hero: Hero
    lateinit var wizard: Wizard

    @Before
    fun setUp() {
        hero = Hero("hero",5, Sword("common sword", 5))
        wizard = Wizard("wizard", 10, 5, 5)
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
        val wizardWithLowMp = Wizard("wizardWithLowMp", 40, 2, 5)
        val heroHpBeforeHealed = hero.hp
        wizardWithLowMp.heal(hero)
        assertEquals(heroHpBeforeHealed, hero.hp)
    }
}
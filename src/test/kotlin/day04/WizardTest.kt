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
        wizard = Wizard("wizard", 10, 5)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun heal() {
        wizard.heal(hero)

        assertEquals(10, hero.hp)
    }
}
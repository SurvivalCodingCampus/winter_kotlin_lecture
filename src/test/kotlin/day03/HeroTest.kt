package day03

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard
import org.example.day04.Enemy
import org.example.day05.Wand

class HeroTest {
    lateinit var hero: Hero
    lateinit var wizard: Wizard
    lateinit var enemy: Enemy

    @Before
    fun setUp() {
        hero = Hero("hero",5, 12, Sword("common sword", 5))
        wizard = Wizard("wizard", 10, 5, 5, Wand("common wand", 5.0))
        enemy = Enemy("enemy")  // hp = MAX_HP(20)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun attack() {
        hero.attack(enemy)

        assertEquals(15, enemy.hp)
    }

    @Test
    fun getHeal() {
        wizard.heal(hero)

        assertEquals(10, hero.hp)
    }
}
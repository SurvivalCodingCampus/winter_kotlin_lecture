package day04

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard
import org.example.day04.Enemy

class EnemyTest {
    lateinit var hero: Hero
    lateinit var wizard: Wizard
    lateinit var enemy: Enemy

    @Before
    fun setUp() {
        hero = Hero("hero",5, Sword("common sword", 5))
        wizard = Wizard("wizard", 10, 5)
        enemy = Enemy("enemy")  // hp = MAX_HP(20)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun attacked() {
        hero.attack(enemy)

        assertEquals(15, enemy.hp)
    }
}
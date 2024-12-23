package day06

import org.example.day06.Hero
import org.example.day06.Slime
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SlimeTest {
    private lateinit var slime: Slime

    @Before
    fun setUp() {
        slime = Slime()
    }

    @Test
    fun `attack 테스트`() {
        val hero = Hero(name = "김영웅")
        slime.attack(hero)
        assertEquals(hero.maxHp - hero.hp, slime.damage)
    }
}
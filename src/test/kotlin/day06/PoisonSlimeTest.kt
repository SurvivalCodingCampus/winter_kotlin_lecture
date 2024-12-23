package day06

import org.example.day03.Hero
import org.junit.Test

import org.junit.Assert.*

class PoisonSlimeTest {

    @Test
    fun `common attack`() {
        val poisonSlime = PoisonSlime("poison slime")
        val hero = Hero("hero")

        poisonSlime.attack(hero)
        assertEquals(30, hero.hp)   // 일반 공격 10, 독 포자 공격 10
    }

    @Test
    fun `out of poison attack count`() {
        val poisonSlime = PoisonSlime("poison slime")
        val hero = Hero("hero")

        for(i in 1..6) {
            poisonSlime.attack(hero)
        }

        assertEquals(0, poisonSlime.poisonCount)
    }
}
package day06

import day03.Hero
import org.junit.Test

import org.junit.Assert.*

class PoisonSlimeTest {

    @Test
    fun checkAttack() {
        //todo 수정 필요
        val hero = Hero("다덤벼", hp = 100)
        val poisonSlime = PoisonSlime("악당", 99)
        poisonSlime.attack(hero)
        assertEquals(poisonSlime.poisonCount, 4)
//        assertEquals(hero.hp, 100 - (hero.hp / 5))
        poisonSlime.attack(hero)
        assertEquals(poisonSlime.poisonCount, 3)
//        assertEquals(hero.hp, 100 - (hero.hp / 5) * 2)

    }
}
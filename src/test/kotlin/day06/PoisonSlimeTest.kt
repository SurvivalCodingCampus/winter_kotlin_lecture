package day06

import day03.Hero
import kotlin.test.Test
import kotlin.test.assertEquals

class PoisonSlimeTest {

    @Test
    fun `독공격 가능 횟수 이상으로 공격 불가 및 음수 안 됨 확인`() {
        val hero = Hero("용사", 100)
        val slime = PoisonSlime("독슬라임")
        val count = slime.poisonCount

        for (i in 1..count + 1) {
            slime.attack(hero)
        }

        assertEquals(0, slime.poisonCount)
    }

}
package day04

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

import org.example.day03.Hero
import org.example.day04.Sword
import org.example.day04.Wizard
import org.example.day04.Enemy
import org.example.day05.Wand

class EnemyTest {
    lateinit var hero: Hero
    lateinit var wizard: Wizard
    lateinit var enemy: Enemy

    @Before
    fun setUp() {
        hero = Hero("hero",5, Sword("common sword", 5))
        wizard = Wizard("wizard", 10, 5, 5, Wand("common wand", 5.0))
        enemy = Enemy("enemy")  // hp = MAX_HP(20)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun attacked() {
        hero.attack(enemy)

        assertEquals(15, enemy.hp)

        // 적의 hp가 0이 되는 경우
        // 적이 이미 사망한 상태
        for(cnt in 1..5) {
            hero.attack(enemy)
        }
        assertTrue("적의 HP가 0 이하가 되었습니다.", enemy.hp <= 0)
        assertFalse("적이 사망했습니다.", enemy.getAlive())
    }
}
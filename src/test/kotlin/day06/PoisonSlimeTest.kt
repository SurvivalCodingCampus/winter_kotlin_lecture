package day06

import org.example.day03.Hero
import org.example.day06.PoisonSlime
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PoisonSlimeTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

//    @Test
//    fun `독슬라임이 정해진 공격횟수 5회만큼 정상적으로 공격하는지`() {
//        // hero 의 초기 체력은 100으로 독 데미지 최솟값은 1
//        // hero 의 체력이 0이 될 때까지 공격
//        val poisonSlime = PoisonSlime(100,"A")
//        val hero = Hero("용사", hp = 100)
//        while (0 < hero.hp) {
//            // 공격횟수가 정상적으로 감소하는지 확인
//            when (poisonSlime.poisonCount) {
//                5 -> assertEquals(5, poisonSlime.poisonCount)
//                4 -> assertEquals(4, poisonSlime.poisonCount)
//                3 -> assertEquals(3, poisonSlime.poisonCount)
//                2 -> assertEquals(2, poisonSlime.poisonCount)
//                1 -> assertEquals(1, poisonSlime.poisonCount)
//                0 -> assertEquals(0, poisonSlime.poisonCount)
//            }
//
//            poisonSlime.attack(hero)
//
//            // 공격횟수가 0이 될 때까지
//            when (poisonSlime.poisonCount) {
//                4 -> assertEquals(18, poisonSlime.poisonDamage)
//                3 -> assertEquals(12, poisonSlime.poisonDamage)
//                2 -> assertEquals(8, poisonSlime.poisonDamage)
//                1 -> assertEquals(4, poisonSlime.poisonDamage)
//                0 -> assertEquals(1, poisonSlime.poisonDamage)
//            }
//
//            // 독 데미지가 1미만이 되는 경우 독 데미지는 1
//            if (1 > (hero.hp/5)) {
//                assertEquals(1, poisonSlime.poisonDamage)
//            }
//        }
//    }
}
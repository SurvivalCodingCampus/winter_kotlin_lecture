package day06

import org.example.day06.Hero
import org.example.day06.PoisonSlime
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PoisonSlimeTest {
    private lateinit var poisonSlime: PoisonSlime

    @Before
    fun setUp() {
        poisonSlime = PoisonSlime()
    }

    @Test
    fun `attack 테스트`() {
        val hero = Hero("김영웅")
        poisonSlime.attack(hero)
        assertEquals(
            hero.maxHp - hero.hp,
            poisonSlime.damage + hero.maxHp / PoisonSlime.POISON_DAMAGE_RATIO_OF_MAX_HP
        )
    }
}
package day06

import org.example.day06.Hero
import org.example.day06.PoisonSlime
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PoisonSlimeTest {

    lateinit var hero: Hero
    lateinit var poisonSlime: PoisonSlime

    @Before
    fun setUp() {
        hero = Hero(name = "히어로", hp = 100)
        poisonSlime = PoisonSlime("T")
    }

    @Test
    fun `attack - hp가 0이하면 공격불가1`() {
        // 첫 번째 공격
        poisonSlime.attack(hero)
        assertEquals(72, hero.hp)
        assertEquals(4, poisonSlime.poisonCount)

        // 두 번째 공격
        poisonSlime.attack(hero)
        assertEquals(50, hero.hp)
        assertEquals(3, poisonSlime.poisonCount)

        // 세 번째 공격
        poisonSlime.attack(hero)
        assertEquals(32, hero.hp)
        assertEquals(2, poisonSlime.poisonCount)

        // 네 번째 공격
        poisonSlime.attack(hero)
        assertEquals(18, hero.hp)
        assertEquals(1, poisonSlime.poisonCount)

        // 다섯 번째 공격
        poisonSlime.attack(hero)
        assertEquals(7, hero.hp)
        assertEquals(0, poisonSlime.poisonCount)

        // 여섯 번째 공격: 독 공격 불가
        poisonSlime.attack(hero)
        assertEquals(0, hero.hp)
        assertEquals(0, poisonSlime.poisonCount) // poisonCount 변화 없음
    }

    @Test
    fun `attack - hp가 0이하면 공격불가`() {
        hero.hp = 5

        poisonSlime.attack(hero)
        assertEquals(0, hero.hp)
        assertEquals(5, poisonSlime.poisonCount)
    }

    @Test
    fun `attack - poisonCount 0이하면 독 공격불가`() {
        val hero = Hero(name = "히어로", hp = 100)
        poisonSlime.poisonCount = 0

        poisonSlime.attack(hero)
        assertEquals(90, hero.hp) //기본공격 10
        assertEquals(0, poisonSlime.poisonCount)
    }
}
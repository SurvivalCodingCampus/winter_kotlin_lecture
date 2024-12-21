package day03

import org.junit.Before
import org.junit.After
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals

class HeroTest {

    private lateinit var hero: Hero

    @Before
    fun setUp() {
        hero = Hero(name = "Batman", 50)
    }
    // 테스트 시행 전에 수행되는 부분

    @After
    fun tearDown() {
    }
    // 테스트 수행 후에 수행되는 부분

    @Test
    fun `공격시 hp 감소`() {
        val slime = Slime("tester", 100)
        hero.hp = 100
        hero.attack(slime)
        val expectedHp = 100 - Hero.HP_BY_ATTACK
        assertEquals(expectedHp, hero.hp)
    }

    @Test
    fun `hp 부족시 공격 불가`() {
        val slime = Slime("tester", 100)
        hero.hp = 0
        hero.attack(slime)
        assertEquals(0, hero.hp)
    }

    @Test
    fun `잠을 자면 hp가 100으로 회복됨 `() {
        // 실행
        hero.sleep()

        // 확인
        assertEquals(100, hero.hp)
    }

    @Test
    fun `이름이 짧으면 예외 발생`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Hero(name = "A", hp = 50)
        }
        assertEquals("이름이 너무 짧습니다", exception.message)
    }

    @Test
    fun `이름이 길면 예외 발생`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Hero(name = "ABCDEFGHI", hp = 50)
        }
        assertEquals("이름이 너무 깁니다", exception.message)
    }

    @Test
    fun `이름이 적절한 길이라면 hero 정상 생성`() {
        val hero = Hero(name = "Batman", hp = 50)
        assertEquals("Batman", hero.name)
        assertEquals(50, hero.hp)
    }

}
package day06

import org.example.day06.Hero
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll

class HeroTest {
    private lateinit var hero: Hero
    private val testName = "김용사"

    @Before
    fun setUp() {
        hero = Hero(name = testName)
    }

    @Test
    fun `기본 값 초기화 확인`() {
        assertEquals(testName, hero.name)
        assertEquals(Hero.DEFAULT_MAX_HP, hero.hp)
        assertEquals(Hero.DEFAULT_MAX_MP, hero.mp)
        assertNull(hero.weapon)
    }

    @Test
    fun `reduceHp 테스트`() = assertAll(
        "init hp = max, damage = [-1, 30, maxHp, maxHp + 1]",
        {
            assertThrows(IllegalArgumentException::class.java) {
                hero.reduceHp(-1)
            }
        },
        {
            hero.reduceHp(30)
            assertEquals(Hero.DEFAULT_MAX_HP - 30, hero.hp)
        },
        {
            hero.reduceHp(Hero.DEFAULT_MAX_HP)
            assertEquals(0, hero.hp)
        },
        {
            hero.reduceHp(Hero.DEFAULT_MAX_HP + 1)
            assertEquals(0, hero.hp)
        },
    )

    @Test
    fun `reduceMp 테스트`() = assertAll(
        "init mp = max, cost = [-1, 30, maxMp, maxMp + 1]",
        {
            assertThrows(IllegalArgumentException::class.java) {
                hero.reduceMp(-1)
            }
        },
        {
            hero.reduceMp(30)
            assertEquals(Hero.DEFAULT_MAX_MP - 30, hero.mp)
        },
        {
            hero.reduceMp(Hero.DEFAULT_MAX_MP)
            assertEquals(0, hero.mp)
        },
        {
            hero.reduceMp(Hero.DEFAULT_MAX_MP + 1)
            assertEquals(0, hero.mp)
        },
    )

    @Test
    fun `recoverHp 테스트`() {
        hero.reduceHp(Hero.DEFAULT_MAX_HP)
        assertAll(
            "init hp = 0, heal = [-1, 30, max+1]",
            {
                assertThrows(IllegalArgumentException::class.java) {
                    hero.recoverHp(-1)
                }
            },
            {
                hero.recoverHp(30)
                assertEquals(30, hero.hp)
            },
            {
                hero.recoverHp(Hero.DEFAULT_MAX_HP + 1)
                assertEquals(Hero.DEFAULT_MAX_HP, hero.hp)
            }
        )
    }

    @Test
    fun `recoverMp 테스트`() {
        hero.reduceMp(Hero.DEFAULT_MAX_MP)
        assertAll(
            "init mp = 0, heal = [-1, 30, max+1]",
            {
                assertThrows(IllegalArgumentException::class.java) {
                    hero.recoverMp(-1)
                }
            },
            {
                hero.recoverMp(30)
                assertEquals(30, hero.mp)
            },
            {
                hero.recoverMp(Hero.DEFAULT_MAX_MP + 1)
                assertEquals(Hero.DEFAULT_MAX_MP, hero.mp)
            }
        )
    }
}
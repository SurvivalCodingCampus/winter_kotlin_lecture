package day3

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class HeroTest {

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun hpAfterResting() {
        val hero = Hero("홍길동", 100)
        hero.hp.percent = 50F
        hero.rest()
        assertEquals(100, hero.hp.value)

    }
}
package day03

import org.example.day03.Cleric
import org.example.day03.MAX_HP
import org.example.day03.MAX_MP
import org.example.day03.USE_MP_SELF_AID
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll


class ClericTest {
    @Test
    fun `Cleric Pray input Test`(): Unit = assertAll(
        "sec > 0, sec == 0, sec < -1",
        {
            val hero = Cleric(name = "성직자")
            assertEquals(0, hero.pray(1))
            assertEquals(0, hero.pray(2))
            assertEquals(0, hero.pray(3))
        },
        {
            val hero = Cleric(name = "성직자", hp = 30, mp = 5)
            hero.pray(4)
            assertEquals(hero.mp, hero.mp.coerceIn(0..MAX_MP))
        },
        {
            val hero = Cleric(name = "성직자", hp = 30, mp = 5)
            hero.pray(100000)
            assertEquals(true, hero.mp == MAX_MP)
            assertEquals(true, hero.pray(0) == 0)
            assertEquals(true, hero.pray(-1) == 0)
        },
    )

    @Test
    fun `Cleric self Aid normal Test`() = assertAll(
        "mp is 0 or lager than 0",
        {
            val hero = Cleric(name = "박명수", mp = MAX_HP, hp = 10)
            hero.selfAid()
            assertEquals(MAX_HP - USE_MP_SELF_AID, hero.mp)
            assertEquals(MAX_HP, hero.hp)
        },
        {
            val hero = Cleric(name = "박명수", mp = 0, hp = 10)
            hero.selfAid()
            assertEquals(10, hero.hp)
        }
    )
}



package day03

import org.example.day03.Cleric
import org.example.day03.MAX_HP
import org.example.day03.MAX_MP
import org.junit.Test
import org.junit.Assert.*


class ClericTest {

    @Test
    fun `Cleric Pray Test`() {
        val sec = 6
        val count = (sec / 3)

        // given(준비)
        val hero = Cleric(name = "하하")

        hero.usingMp(4)

        // when(실행)
        val totalRecoveredMp = hero.pray(sec)

        hero.showingStatus()

        // then(random number 검증)
        assertTrue("Something wrong with random", totalRecoveredMp in count * 2..count * 3)

        // then(검증)
        assertTrue(
            "Cleric Info : ${hero.name} \n recovered hp : $totalRecoveredMp  \n  0 < ${hero.mp} < $MAX_MP",
            hero.mp in 0..MAX_MP
        )
    }

    @Test
    fun `Cleric self Aid Test`() {

        // given(준비)
        val hero = Cleric(name = "박명수")

        val damage = 30
        val consumed = 10

        hero.showingStatus()

        // when(실행)
        // 데미지 입력
        hero.getDamaged(damage)

        hero.showingStatus()

        // then(hp 검증)
        assertEquals(MAX_HP - damage, hero.hp)

        // mp 사용
        hero.usingMp(consumed)

        // mp 사용
        hero.usingMp(consumed)

        // skill 사용 (mp가 없음)
        hero.selfAid()

        // then(selfAid 사용후 hp 검증)
        assertEquals(MAX_HP - damage, hero.hp)
        assertEquals(0, hero.mp)

    }
}



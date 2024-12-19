package day03

import org.junit.Test

import org.junit.Assert.*


class ClericTest {

    @Test
    fun `mp 부족시 selfAid가 동작하지 않는다`() {
        // 준비
        val cleric = Cleric("tester", hp = 30, mp = 4)

        // 실행
        cleric.selfAid()

        // 미회복 확인
        assertEquals(30, cleric.hp)
        assertEquals(4, cleric.mp)
    }

    @Test
    fun `mp를 사용하여 hp를 회복한다`() {
        // 준비
        val cleric = Cleric("tester", hp = 30)

        // 실행
        cleric.selfAid()

        // 회복 확인
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals((Cleric.MAX_MP - Cleric.MP_FOR_AID), cleric.mp)
    }

    @Test
    fun `회복 후 mp는 maxMP를 초과할 수 없다`() {
        // 준비
        val cleric = Cleric("tester", mp = 9)

        // 실행
        val actualRecover = cleric.pray(2)

        // 확인
        assertTrue(actualRecover in 0..1)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `pray 동작시 (초 + 0~2) 만큼 mp가 충전된다 `() {
        // 준비
        val cleric = Cleric("tester", mp = 5)

        // 실행
        val actualRecover = cleric.pray(2)

        // 확인
        assertTrue(actualRecover in 2..4)
        assertTrue(cleric.mp in 7..9)
    }

}
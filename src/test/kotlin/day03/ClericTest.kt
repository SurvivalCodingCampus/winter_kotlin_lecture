package day03

import org.example.day03.Cleric
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClericTest {
    private lateinit var cleric: Cleric

    @Before
    fun setUp() {
        cleric = Cleric(name = "힐러")
    }

    @Test
    fun `Cleric 초기 정보 확인`() {
        // 요구 사항 2: 생성자 확인
        Cleric(name = "아서스", hp = 40, mp = 5)
        Cleric(name = "아서스", hp = 35)
        Cleric(name = "아서스")
        assertEquals(expected = "힐러", cleric.name)
        assertEquals(expected = Cleric.MAX_HP, cleric.hp)
        assertEquals(expected = Cleric.MAX_HP, Cleric.MAX_HP)
        assertEquals(expected = Cleric.MAX_MP, cleric.mp)
        assertEquals(expected = Cleric.MAX_MP, Cleric.MAX_MP)
    }

    @Test
    fun `selfAid 사용 후 hp, mp 확인 (init hp, mp = 2, 10)`() {
        cleric.hp = 2
        val currentMp = cleric.mp
        cleric.selfAid()
        assertEquals(cleric.hp, Cleric.MAX_HP)
        assertEquals(currentMp - Cleric.MP_COST_OF_SELF_AID, cleric.mp)
    }

    @Test
    fun `pray (init mp, time = 0, 3)`() {
        cleric.mp = 0
        val time = 3
        val recoveryMp = cleric.pray(time)
        assertTrue(recoveryMp in time..time + 2)
        assertTrue(cleric.mp in 3..5)
    }

    @Test
    fun `pray time 0초 이하일 경우 `() {
        cleric.mp = 0
        (-1..0).forEach { time ->
            val recoveryMp = cleric.pray(time)
            assertEquals(0, recoveryMp)
            assertEquals(0, cleric.mp)
        }
    }

    @Test
    fun `pray full mp 일 경우`() {
        val time = 2
        val recoveryMp = cleric.pray(time)
        assertEquals(0, recoveryMp)
        assertEquals(cleric.mp, Cleric.MAX_MP)
    }
}
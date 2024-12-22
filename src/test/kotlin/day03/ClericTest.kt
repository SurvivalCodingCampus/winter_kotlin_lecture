package day03

import org.hyunjung.day03.Cleric
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ClericTest {

    private lateinit var cleric: Cleric

    @Before
    fun setUp() {
        cleric = Cleric(name = "Priest")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `기도 시간이 0이나 음수일 때 예외 발생`() {
        cleric.pray(0) // 예외 발생
    }

    @Test
    fun `이미 MP가 최대일 때 기도하면 회복하지 않음`() {
        cleric.mp = Cleric.MAX_MP
        val recoveryAmount = cleric.pray(5)
        assertEquals(0, recoveryAmount)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `기도 시간이 너무 클 때 최대 10초로 제한`() {
        cleric.mp = 5
        val recoveryAmount = cleric.pray(100)
        assertTrue(cleric.mp <= Cleric.MAX_MP)
        assertEquals(5, recoveryAmount)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `정상적인 기도 실행 확인`() {
        cleric.mp = 5
        val recoveryAmount = cleric.pray(3)
        assertTrue(recoveryAmount in 3..5)
        assertTrue(cleric.mp in 8..10)
    }

    @Test
    fun `MP가 5 이상일 때 Self Aid가 정상 동작`() {
        cleric.hp = 30
        cleric.mp = 5
        cleric.selfAid()
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals(0, cleric.mp)
    }

    @Test
    fun `MP가 5 미만일 때 Self Aid가 실패`() {
        cleric.hp = 30
        cleric.mp = 4
        cleric.selfAid()
        assertEquals(30, cleric.hp)
        assertEquals(4, cleric.mp)
    }
}
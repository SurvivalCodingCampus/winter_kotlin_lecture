package day3

import org.junit.Assert.assertEquals
import org.junit.Test

class ClericTest {

    @Test
    fun testSelfAid_NotEnoughMP() {
        val clericSubject = Cleric("Tester", hp = 2, mp = 3)
        clericSubject.selfAid()

        assertEquals("HP should remain unchanged", clericSubject.hp, 2)
        assertEquals("MP should remain unchanged", clericSubject.mp, 3)
    }

    @Test
    fun testSelfAid_ReplenishHP() {
        val clericSubject = Cleric("Tester", hp = 2, mp = 5)
        clericSubject.selfAid()

        assertEquals("HP should be restored", clericSubject.hp, Cleric.MAX_HP)
        assertEquals("MP should be 5 less", clericSubject.mp, 0)
    }


    @Test
    fun testPray_Overflow() {
        val clericSubject = Cleric("Tester", mp = 9)
        val restoredMp = clericSubject.pray(Cleric.MAX_MP.toDouble())
        assertEquals(clericSubject.mp, Cleric.MAX_MP)
        assertEquals(restoredMp, 1)
    }


    @Test(expected = Cleric.NegativeTimeException::class)
    fun testPray_NegativeInput() {
        val clericSubject = Cleric("Tester", mp = 9)
        clericSubject.pray(-1.0)
    }

    @Test
    fun testPray_InputZero() {
        val clericSubject = Cleric("Tester", mp = 9)
        val restoredMp = clericSubject.pray(0.0)
        assertEquals(restoredMp, 0);
        assertEquals(clericSubject.mp, 9)
    }
}
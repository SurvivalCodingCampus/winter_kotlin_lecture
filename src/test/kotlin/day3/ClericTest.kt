package day3

import org.junit.Assert.assertEquals
import org.junit.Test

class ClericTest {

    @Test
    fun testSelfAid_NotEnoughMP() {
        val clericSubject = Cleric("Tester", hp = 2, mp = 3)
        clericSubject.selfAid()

        assertEquals("HP should remain unchanged", 2, clericSubject.hp)
        assertEquals("MP should remain unchanged", 3, clericSubject.mp)
    }

    @Test
    fun testSelfAid_ReplenishHP() {
        val clericSubject = Cleric("Tester", hp = 2, mp = 5)
        clericSubject.selfAid()

        assertEquals("HP should be restored", Cleric.MAX_HP, clericSubject.hp)
        assertEquals("MP should be 5 less", 0, clericSubject.mp)
    }


    @Test
    fun testPray_Overflow() {
        val clericSubject = Cleric("Tester", mp = 9)
        val restoredMp = clericSubject.pray(Cleric.MAX_MP.toDouble())
        assertEquals(Cleric.MAX_MP, clericSubject.mp)
        assertEquals(1, restoredMp)
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
        assertEquals(0, restoredMp);
        assertEquals(9, clericSubject.mp)
    }
}
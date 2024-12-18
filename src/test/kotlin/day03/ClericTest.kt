package day03

import org.example.day03.Cleric
import org.junit.Test
import kotlin.test.assertEquals

class ClericTest {
    @Test
    fun initCleric() {
        val newName = "힐러"
        val cleric = Cleric(name = newName)
        assertEquals(expected = newName, cleric.name)
        assertEquals(expected = 50, cleric.currentHp)
        assertEquals(expected = 50, cleric.maxHp)
        assertEquals(expected = 10, cleric.currentMp)
        assertEquals(expected = 10, cleric.maxMp)
    }

    @Test
    fun pray() {
        val cleric = Cleric(name = "힐러")
        cleric.currentMp = 0
        val time = 3
        val recoveryMp = cleric.pray(time)
        assertEquals(true, recoveryMp in time..time + 2)
        assertEquals(true, cleric.currentMp in 3..5)
    }

    @Test
    fun prayZeroTime() {
        val cleric = Cleric("힐러")
        cleric.currentMp = 0
        val time = 0
        val recoveryMp = cleric.pray(time)
        assertEquals(0, recoveryMp)
        assertEquals(0, cleric.currentMp)
    }

    @Test
    fun prayWhenFullMp() {
        val cleric = Cleric("힐러")
        val time = 2
        val recoveryMp = cleric.pray(time)
        assertEquals(0, recoveryMp)
        assertEquals(10, cleric.currentMp)
    }

    @Test
    fun selfAid() {
        val cleric = Cleric(name = "힐러")
        cleric.currentHp = 2
        cleric.selfAid()
        assertEquals(50, cleric.currentHp)
        assertEquals(5, cleric.currentMp)
    }
}
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
    fun initCleric() {
        assertEquals(expected = "힐러", cleric.name)
        assertEquals(expected = 50, cleric.currentHp)
        assertEquals(expected = 50, cleric.maxHp)
        assertEquals(expected = 10, cleric.currentMp)
        assertEquals(expected = 10, cleric.maxMp)
    }

    @Test
    fun pray() {
        cleric.currentMp = 0
        val time = 3
        val recoveryMp = cleric.pray(time)
        assertTrue(recoveryMp in time..time + 2)
        assertTrue(cleric.currentMp in 3..5)
    }

    @Test
    fun prayZeroTime() {
        cleric.currentMp = 0
        val time = 0
        val recoveryMp = cleric.pray(time)
        assertEquals(0, recoveryMp)
        assertEquals(0, cleric.currentMp)
    }

    @Test
    fun prayWhenFullMp() {
        val time = 2
        val recoveryMp = cleric.pray(time)
        assertEquals(0, recoveryMp)
        assertEquals(10, cleric.currentMp)
    }

    @Test
    fun selfAid() {
        cleric.currentHp = 2
        cleric.selfAid()
        assertEquals(50, cleric.currentHp)
        assertEquals(5, cleric.currentMp)
    }
}
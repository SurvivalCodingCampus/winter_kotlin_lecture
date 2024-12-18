package day03

import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertContains

class ClericTest {

    @Test
    fun selfAid() {
        // 준비
        val cleric = Cleric(hp = 50, mp = 10)

        // 실행
        cleric.selfAid()

        // 검증
        assertEquals(Cleric.MAX_MP - 5, cleric.mp)
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }


    // 초과될경우
    @Test
    fun prayOver() {

        // 준비
        val cleric = Cleric(hp = 50, mp = 5)

        // 입력할 praySecond
        val praySecond = 6

        // 실행
        val result = cleric.pray(praySecond)

        // 검증
        assertEquals(5, result)
    }

    // 초과되지 않을 경우
    @Test
    fun prayNotOver() {
        // 준비
        val cleric = Cleric(hp = 50, mp = 5)

        // 입력할 praySecond
        val praySecond = 3

        // 실행
        val result = cleric.pray(praySecond)

        // 검증
        assertContains((3..5), result)

    }
}
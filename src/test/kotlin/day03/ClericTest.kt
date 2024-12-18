package day03

import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertContains

class ClericTest {


    // 마법을 사용하기에 현재 mp가 충분한 경우
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

    // 마법을 사용하기에 현재 mp가 부족한 경우
    @Test
    fun selfAidDeficientMp() {
        // 준비
        val cleric = Cleric(hp = 40, mp = 3)
        val initialHp = cleric.hp
        val initialMp = cleric.mp

        // 실행
        cleric.selfAid()

        // 검증
        assertEquals(initialHp, cleric.hp)
        assertEquals(initialMp, cleric.mp)
    }



    // 회복했을때 회복량 + mp > MAX_MP
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
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    // 회복했을때 회복량 + mp <= MAX_MP
    @Test
    fun prayNotOver() {
        // 준비
        val cleric = Cleric(hp = 50, mp = 5)
        val initialMp = cleric.mp

        // 입력할 praySecond
        val praySecond = 3

        // 실행
        val result = cleric.pray(praySecond)

        // 검증
        assertContains((3..5), result)
        assertEquals(initialMp + result, cleric.mp)

    }
}
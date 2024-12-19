package day03

import org.junit.Test

import org.junit.Assert.*

class ClericTest {

    @Test
    fun selfAid() {
        //given 준비
        val cleric = Cleric("용사", hp = 30, mp = 5)
        //when 실행
        cleric.selfAid()
        //then 검증
        assertEquals(50, cleric.hp)
    }

    @Test
    fun selfAid2() {
        //given 준비
        val cleric = Cleric("용사", hp = 50, mp = 5)
        //when 실행
        cleric.selfAid()
        //then 검증
        assertEquals(50, cleric.hp)
    }

    @Test
    fun selfAid3() {
        //given 준비
        val cleric = Cleric("용사", hp = 30, mp = 3)
        //when 실행
        cleric.selfAid()
        //then 검증
        assertEquals(50, cleric.hp)
    }

    @Test
    fun pray() {
        //given 준비
        val cleric = Cleric("용사", mp = 6)
        //when 실행
        //then 검증
        assertTrue(cleric.pray(3) in 3..5)
    }

}


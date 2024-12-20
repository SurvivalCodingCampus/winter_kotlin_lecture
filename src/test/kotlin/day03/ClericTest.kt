package day03

import day03.Cleric.Companion.MAX_HP
import day03.Cleric.Companion.MAX_MP
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
    fun selfAbidFull() {
        //given 준비
        val cleric = Cleric("용사", hp = 50, mp = 5)
        //when 실행
        cleric.selfAid()
        //then 검증
        assertEquals(50, cleric.hp)
    }

    @Test
    fun selfAidLess() {
        //given 준비
        val cleric = Cleric("용사", hp = 30, mp = 3)
        //when 실행
        cleric.selfAid()
        //then 검증
        assertTrue(cleric.hp != MAX_HP)     //assertTrue(value) : 값이 True인지 체크 한다.
    }


    @Test
    fun pray() {
        //given 준비
        val cleric = Cleric("용사", mp=6)
        //when 실행
        //then 검증
        assertTrue(cleric.pray(3) in 3..5)
    }

    @Test
    fun clericConstructor() {
        //given 준비
        val cleric1 = Cleric(name = "아서스", hp = 40, mp = 5)
        //when 실행
        //then 검증
        assertEquals("아서스", cleric1.name)
        assertEquals(40, cleric1.hp)
        assertEquals(5, cleric1.mp)

        var cleric2: Cleric = Cleric("아서스", hp = 35)
        assertEquals("아서스", cleric2.name)
        assertEquals(35, cleric2.hp)
        assertEquals(MAX_MP, cleric2.mp)

        var cleric3: Cleric = Cleric("아서스")
        assertEquals("아서스", cleric3.name)
        assertEquals(Cleric.MAX_HP, cleric3.hp)     //호출 두가지 방법) import 안 했을 때
        assertEquals(MAX_MP, cleric3.mp)            //import 했을 때, 클래스명 없이 MAX_MP 단독 사용 가능

    }
}


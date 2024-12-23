package day04

import org.hyunjung.day04.Cleric
import org.junit.Assert.assertEquals
import org.junit.Test

class ClericTest {

    // A) 이름, HP, MP를 지정하여 생성
    @Test
    fun `이름, HP, MP를 지정하여 생성`() {
        val cleric = Cleric(name = "아서스", hp = 40, mp = 5)
        assertEquals("아서스", cleric.name)
        assertEquals(40, cleric.hp)
        assertEquals(5, cleric.mp)
        assertEquals(Cleric.MAX_HP, Cleric.MAX_HP)
        assertEquals(Cleric.MAX_MP, Cleric.MAX_MP)
    }

    // B) 이름과 HP만 지정하여 생성
    @Test
    fun `이름과 HP만 지정하여 생성`() {
        val cleric = Cleric(name = "아서스", hp = 35)
        assertEquals("아서스", cleric.name)
        assertEquals(35, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    // C) 이름만 지정하여 생성
    @Test
    fun `이름만 지정하여 생성`() {
        val cleric = Cleric(name = "아서스")
        assertEquals("아서스", cleric.name)
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    // D) 이름을 지정하지 않는 경우 - 컴파일 에러로 인해 테스트할 필요 없음

    @Test(expected = IllegalArgumentException::class)
    fun `이름이 빈 문자열이면 예외 발생`() {
        Cleric(name = "")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `HP가 유효 범위를 벗어나면 예외 발생`() {
        Cleric(name = "아서스", hp = 60)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `MP가 유효 범위를 벗어나면 예외 발생`() {
        Cleric(name = "아서스", hp = 40, mp = -1)
    }
}
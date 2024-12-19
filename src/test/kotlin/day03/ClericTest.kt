package day03

import org.junit.Test


import org.example.day03.Cleric
import org.example.day03.MAX_HP
import org.example.day03.MAX_MP
import kotlin.test.assertEquals

class ClericTest {

    @Test
    fun `Cleric 인스턴스화 테스트 name,hp,mp`() {
        val cleric = Cleric("아서스", hp = 35, mp = 3)
        assertEquals("아서스", cleric.name)
        assertEquals(35, cleric.hp)
        assertEquals(3, cleric.mp)
    }

    @Test
    fun `Cleric 인스턴스화 테스트 name,hp`() {
        val cleric = Cleric("아서스", hp = 30)
        assertEquals("아서스", cleric.name)
        assertEquals(30, cleric.hp)
        assertEquals(MAX_MP, cleric.mp)
    }

    @Test
    fun `Cleric 인스턴스화 테스트 name`() {
        val cleric = Cleric("아서스")
        assertEquals("아서스", cleric.name)
        assertEquals(MAX_HP, cleric.hp)
        assertEquals(MAX_MP, cleric.mp)
    }

    @Test
    fun `selfAid - mp가 5이상이면 -5되고 hp는 MAX_HP가 된다`() {
        // hp 가 10, mp 가 max 일때
        val cleric = Cleric(name = "아서스")
        cleric.hp = 10

        cleric.selfAid()
        assertEquals(MAX_HP, cleric.hp)
    }

    @Test
    fun `selfAid - mp가 5보다 적으면 hp 회복 안됨`() {
        val cleric = Cleric(name = "아서스")
        // mp가 부족할 때
        cleric.hp = 10
        cleric.mp = 4

        cleric.selfAid()
        assertEquals(true, MAX_HP != cleric.hp)
    }


    @Test
    fun `pray - mp가 10일때 0~1초간 기도하면 mp회복량은 0 이다`() {
        val cleric = Cleric(name = "아서스", hp = 35, mp = 10)
        val chargeMp = cleric.pray((0..1).random())

        assertEquals(cleric.mp + chargeMp, cleric.mp)
    }

    @Test
    fun `pray - mp가 10일때 3초간 기도하면 mp가 회복된다`() {
        val cleric = Cleric(name = "아서스", hp = 35, mp = 10)
        val chargeMp = cleric.pray(3)

        assertEquals(10 + chargeMp, cleric.mp)
    }

    @Test
    fun `pray - mp가 MAX_MP일때 3초간 기도하면 mp회복량은 0 이다`() {
        val cleric = Cleric(name = "아서스", hp = 35, mp = MAX_MP)
        val chargeMp = cleric.pray(3)

        assertEquals(chargeMp, 0)
    }
}
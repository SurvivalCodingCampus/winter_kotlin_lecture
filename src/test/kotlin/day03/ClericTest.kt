package day03

import com.survivalcoding.com.survivalcoding.day03.Cleric
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ClericTest {

    @Test
    fun selfAid() {
        // hp 가 10, mp 가 max 일때
        val cleric = Cleric(name = "아무개")
        cleric.hp = 10

        cleric.selfAid()
        assertEquals(Cleric.MAX_HP, cleric.hp)

        // mp가 부족할 때
        cleric.hp = 10
        cleric.mp = 4

        cleric.selfAid()
        assertEquals(true, Cleric.MAX_HP != cleric.hp)
    }

    @Test
    fun `pray - mp 가 max 인 경우에는 회복 안 됨`() {
        // mp 가 max 인 경우에는 회복 안 됨
        val cleric = Cleric("홍길동")

        assertEquals(0, cleric.pray(1))
        assertEquals(0, cleric.pray(2))
        assertEquals(0, cleric.pray(3))


        // time 이 0 이하이면 회복 안 됨
        cleric.mp = 0
        assertEquals(false, cleric.pray(1) == 0)
        assertEquals(0, cleric.pray(0))
        assertEquals(0, cleric.pray(-1))


        // mp 가 max 가 아니면 회복 됨 sec + (0~2)
        for (sec in 1..Cleric.MAX_MP) {
            cleric.mp = 0
            assertTrue((sec..sec + 2).contains(cleric.pray(sec)))
        }
    }
}
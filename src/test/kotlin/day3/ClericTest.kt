package day3

import org.example.day3.Cleric
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test

class ClericTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `피격 후 회복 과정을 마나 고갈시까지 반복`() {
        val cleric = Cleric(name = "사제")

        while (true) {
            cleric.hp -= 5
            if (cleric.mp < 5) break
            cleric.selfAid()
        }

        assertEquals(45, cleric.hp)
    }

    @Test
    fun `MP가 부족할 때 selfAid는 동작하지 않음`() {
        val cleric = Cleric(name = "사제")
        cleric.mp = 4
        val initialHp = cleric.hp

        cleric.selfAid()

        assertEquals(initialHp, cleric.hp)
        assertEquals(4, cleric.mp)
    }

    @Test
    fun `pray - mp가 max 가 아닐 때 mp 를 회복하는 경우(time + 0~2)`() {
        val cleric = Cleric(name = "사제")
        cleric.mp = (0..<Cleric.MAX_MP).random()
        assertTrue(cleric.pray(3) in 3..5)
    }

    @Test
    fun `pray - mp 가 max 인 경우에는 회복 안 됨`() {
        val cleric = Cleric("홍길동")

        assertEquals(0, cleric.pray(1))
        assertEquals(0, cleric.pray(2))
        assertEquals(0, cleric.pray(3))
    }

    @Test
    fun `pray - mp 가 time 이 0 이하이면 회복 안 됨`() {
        val cleric = Cleric("홍길동")
        cleric.mp = 0

        assertEquals(false, cleric.pray(1) == 0)
        assertEquals(0, cleric.pray(0))
        assertEquals(0, cleric.pray(-1))
    }

    @Test
    fun `연습문제 2-A 인스턴스화`() {
        // 이 클래스는 Cleric(“아서스", hp = 40, mp = 5) 와 같이,
        // 이름, HP, MP 를 지정하여 인스턴스화 할 수 있다
        val cleric1 = Cleric("아서스", hp = 40, mp = 5)

        assertEquals("아서스", cleric1.name)
        assertEquals(40, cleric1.hp)
        assertEquals(5, cleric1.mp)

        // 다른 경우 Cleric(“리치왕", hp = 45, mp = 10)
        val cleric2 = Cleric("리치왕", hp = 45, mp = 10)

        assertEquals("리치왕", cleric2.name)
        assertEquals(45, cleric2.hp)
        assertEquals(10, cleric2.mp)

//        // hp와 mp가 max 보다 큰 경우 Cleric(“리치왕", hp = 55, mp = 15)
//        val cleric3 = Cleric("리치왕", hp = 55, mp = 15)
//
//        assertEquals(Cleric.MAX_HP, cleric3.hp)
//        assertEquals(Cleric.MAX_MP, cleric3.mp)
    }

    @Test
    fun `연습문제 2-B 인스턴스화`() {
        // 이 클래스는 Cleric(“아서스", hp = 35) 와 같이,
        // 이름과 HP만으로 지정하여 인스턴스화 할 수 있다.
        // 이 때, MP는 최대 MP와 같은 값이 초기화 된다
        val cleric1 = Cleric("아서스", hp = 35)

        assertEquals("아서스", cleric1.name)
        assertEquals(35, cleric1.hp)
        assertEquals(Cleric.MAX_MP, cleric1.mp)

        // 다른 경우 Cleric(“리치왕", hp = 45)
        val cleric2 = Cleric("리치왕", hp = 45)

        assertEquals("리치왕", cleric2.name)
        assertEquals(45, cleric2.hp)
        assertEquals(Cleric.MAX_MP, cleric2.mp)
    }
}
package day03

import org.example.day03.Cleric
import org.junit.Assert.*
import kotlin.test.assertContains

class ClericTest {

    @org.junit.Before
    fun setUp() {

    }

    @org.junit.Test
    fun `selfAid method test`() {
        val cleric1 = Cleric("cleric1", 10, 10)

        cleric1.selfAid()

        assertEquals(Cleric.MAX_HP, cleric1.hp)
        assertEquals(5, cleric1.mp)
    }

    @org.junit.Test
    fun `pray method test`() {
        var cleric1 : Cleric
        var mpBeforePray : Int

        val randomHp = 1..50
        val randomMp = 1..10
        val randomPraySecond = 1..30    // 30초 넘게는 지루해서 기도를 안 하지 않을까
        val checkLog : StringBuilder = StringBuilder("")    // input 값 추적을 위한 StringBuilder

        for(count in 1..5) {
            checkLog.appendLine("test$count")
            val testHp = randomHp.random()      // 이런식으로 랜덤하게 뽑아서 하면 안된다.
            val testMp = randomMp.random()      // 풀로 정한 수들을 다 해봐야 한다는 의미이다. 랜덤으로하면 빠진 숫자들은 테스트를 안하게 된 것이 되므로.
            checkLog.appendLine("testHp: $testHp, testMp: $testMp")

            cleric1 = Cleric("cleric1", testHp, testMp)
            mpBeforePray = cleric1.mp

            val testPraySecond = randomPraySecond.random()
            checkLog.appendLine("testPraySecond: $testPraySecond")

            assertContains(0..testPraySecond + 2, cleric1.pray(testPraySecond))   // 실제로 회복된 mp량 검증

            if(mpBeforePray != Cleric.MAX_MP)
                assertContains(mpBeforePray + 1..Cleric.MAX_MP, cleric1.mp)  // 회복하고 난 후 mp, 최소한 mpBeforePray + 1만큼을 존재하여야 한다. + 1을 해주는 이유는 0이면 사망으로 간주
            else
                assertEquals(Cleric.MAX_MP, cleric1.mp)

            checkLog.appendLine("----------")
        }

        println(checkLog)
    }   // 해당 테스트는 다시 만들 예정

    @org.junit.Test
    fun `check initialization of name`() {
        val cleric1 = Cleric("who are you", 10, 10)

        assertEquals("who are you", cleric1.name)
    }

    @org.junit.Test
    fun `test Cleric Constructor`() {
        val clericFullParameter = Cleric("아서스", 40, 5)
        val clericNoMp = Cleric("아서스", 35)
        val clericNoHpMp = Cleric("아서스")

        assertEquals("아서스", clericFullParameter.name)
        assertEquals(40, clericFullParameter.hp)
        assertEquals(5, clericFullParameter.mp)

        assertEquals("아서스", clericNoMp.name)
        assertEquals(35, clericNoMp.hp)
        assertEquals(Cleric.MAX_MP, clericNoMp.mp)

        assertEquals("아서스", clericNoHpMp.name)
        assertEquals(Cleric.MAX_HP, clericNoHpMp.hp)
        assertEquals(Cleric.MAX_MP, clericNoHpMp.mp)
    }
}
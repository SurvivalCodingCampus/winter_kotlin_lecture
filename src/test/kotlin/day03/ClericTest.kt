package day03

import org.example.day03.Cleric
import org.junit.Assert.*
import kotlin.test.assertContains

class ClericTest {

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
    }

    @org.junit.Test
    fun `selfAid method test`() {
        val cleric1 = Cleric("cleric1", 10, 10)

        cleric1.selfAid()

        assertEquals(cleric1.MAX_HP, cleric1.hp)
        assertEquals(5, cleric1.mp)
    }

    @org.junit.Test
    fun `pray method test`() {
        var cleric1 : Cleric    // null 값을 넣지는 않을 것이다.
        var mpBeforePray : Int  // 마찬가지로 null 값을 넣지는 않을 것이다.
        val randomHp = 1..50
        val randomMp = 1..10
        val randomPraySecond = 1..30    // 30초 넘게는 지루해서 기도를 안 하지 않을까
        val checkLog : StringBuilder = StringBuilder("")    // input 값 추적을 위한 StringBuilder

        for(count in 1..5) {
            checkLog.appendLine("test$count")
            val testHp = randomHp.random()
            val testMp = randomMp.random()
            checkLog.appendLine("testHp: $testHp, testMp: $testMp")

            cleric1 = Cleric("cleric1", testHp, testMp)
            mpBeforePray = cleric1.mp

            val testPraySecond = randomPraySecond.random()
            checkLog.appendLine("testPraySecond: $testPraySecond")

            assertContains(0..testPraySecond + 2, cleric1.pray(testPraySecond))   // 실제로 회복된 mp량 검증

            assertContains(mpBeforePray + 1..cleric1.MAX_MP, cleric1.mp)  // 회복하고 난 후 hp, 최소한 mpBeforePray + 1만큼을 존재하여야 한다. + 1을 해주는 이유는 0이면 사망으로 간주

            checkLog.appendLine("----------")
        }

        println(checkLog)
    }

    @org.junit.Test
    fun `check initialization of name`() {
        val cleric1 = Cleric("who are you", 10, 10)

        assertEquals("who are you", cleric1.name)
    }
}
package day03

import org.example.day03.Cleric
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll
import kotlin.random.Random
import kotlin.test.assertIs

class ClericTestJUnit4 {
    lateinit var cleric: Cleric

    @Before
    fun setUp() {
        cleric = createCleric()
        validateCleric()
    }

    @After
    fun tearDown() {
        // 테스트 실행 후에 실행 되는 코드
    }

    @Test
    fun selfAid() {

        val currentMp = cleric.mp
        cleric.selfAid()

        assertEquals("selfAid() 메소드 실행 후 hp 값이 maxHp 값인 50이여야 한다.", 50, cleric.hp)
        assertEquals("selfAid() 메소드 실행 후 mp 값이 5 감소 해야 한다.", currentMp - 5, cleric.mp)


    }

    @Test
    fun pray() {

        val beforeMp = cleric.mp

        val recover = cleric.pray(Random.nextInt(10))

        assert(recover in 0..12) { "pray() 메소드 실행 후 recover 값이 0 이상 12 이하 여야 한다." }
        assert(beforeMp <= cleric.mp) { "pray() 메소드 실행 후 mp 값이 증가 하거나 같아야 한다." }
        assert(0 <= cleric.mp && cleric.mp <= cleric.maxMp) { "pray() 메소드 실행 후 mp 값이 0 이상 maxMp 값인 10이하 여야 한다." }

    }

    fun createCleric(): Cleric {
        val hp = Random.nextInt(50)
        val mp = Random.nextInt(10)
        return Cleric("test", hp, mp)
    }

    fun validateCleric() {
        cleric = createCleric()

        assertAll({
            assertIs<Cleric>(cleric, "Cleric 객체가 생성되지 않았습니다.")
            assertEquals("생성된 cleric의 name 값이 'test'여야 한다.", "test", cleric.name)
            assertEquals("생성된 cleric의 hp 값이 0 이상 50 이하 여야 한다.", true, cleric.hp in 0..50)
            assertEquals("생성된 cleric의 mp 값이 0 이상 10 이하 여야 한다.", true, cleric.mp in 0..10)
            assertEquals("생성된 cleric의 maxHp 값이 50이여야 한다.", 50, cleric.maxHp)
            assertEquals("생성된 cleric의 maxMp 값이 10이여야 한다.", 10, cleric.maxMp)
        })
    }

}
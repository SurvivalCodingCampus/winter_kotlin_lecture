package day03

import org.example.day03.Cleric
import org.example.day4.skills.Prayable
import org.example.day4.skills.SelfAidable
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertContains
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

        cleric.hp = 0
        val currentMp = cleric.mp
        cleric.selfAid()

        assertEquals("selfAid() 메소드 실행 후 hp 값이 maxHp 값인 50이여야 한다.", Cleric.MAX_HP, cleric.hp)
        assertEquals("selfAid() 메소드 실행 후 mp 값이 5 감소 해야 한다.", currentMp - SelfAidable.NEED_MP, cleric.mp)

        val setMp = SelfAidable.NEED_MP - 1

        cleric.mp = setMp

        cleric.selfAid()

        assertEquals("selfAid() 메소드 실행 시 mp가 ${SelfAidable.NEED_MP} 보다 낮다면 mp는 변하지 않아야 한다.", setMp, cleric.mp)


    }

    @Test
    fun pray() {

        val beforeMp = cleric.mp

        val variableSeconds: Array<Int> = arrayOf(-1, 0, 1)

        for (second in variableSeconds) {
            val recoverMP = cleric.pray(second)
            assertEquals(
                "pray() 메소드 실행 후 recover 값이 0 또는 기도한 시간..시간 + Prayable.RANDOM_COLLECTION_MP_RANGE 값이여야 한다.",
                recoverMP == 0 || recoverMP in second..second + Prayable.RANDOM_COLLECTION_MP_RANGE,
                true
            )
            assertEquals("pray() 메소드 실행 후 mp 값이 증가 하거나 같아야 한다.", true, beforeMp <= cleric.mp)
            assertContains(0..Cleric.MAX_MP, cleric.mp, "pray() 메소드 실행 후 mp 값이 0 이상 maxMp 값 이하 여야 한다.")
        }


    }

    fun createCleric(): Cleric {
        return Cleric("test")
    }

    fun validateCleric() {
        cleric = createCleric()

        assertAll({
            assertIs<Cleric>(cleric, "Cleric 객체가 생성되지 않았습니다.")
            assertEquals("생성된 cleric의 name 값이 'test'여야 한다.", "test", cleric.name)
            assertEquals("생성된 cleric의 hp 값이 0 이상 50 이하 여야 한다.", true, cleric.hp in 0..50)
            assertEquals("생성된 cleric의 mp 값이 0 이상 10 이하 여야 한다.", true, cleric.mp in 0..10)
            assertEquals("생성된 cleric의 maxHp 값이 50이여야 한다.", 50, Cleric.MAX_HP)
            assertEquals("생성된 cleric의 maxMp 값이 10이여야 한다.", 10, Cleric.MAX_MP)
        })
    }

}
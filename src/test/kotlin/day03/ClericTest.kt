package day03

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertContains
import kotlin.test.assertFailsWith

class ClericTest {


    // 마법을 사용하기에 현재 mp가 충분한 경우
    @Test
    fun selfAid() {
        // 준비
        val cleric = Cleric(name = "아서스", hp = 50, mp = 10)

        // 실행
        cleric.selfAid()

        // 검증
        assertEquals(Cleric.MAX_MP - 5, cleric.mp)
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }

    // 마법을 사용하기에 현재 mp가 부족한 경우
    @Test
    fun selfAidDeficientMp() {
        // 준비
        val cleric = Cleric(name = "아서스", hp = 40, mp = 3)
        val initialHp = cleric.hp
        val initialMp = cleric.mp

        // 실행
        cleric.selfAid()

        // 검증
        assertEquals(initialHp, cleric.hp)
        assertEquals(initialMp, cleric.mp)
    }


    // 회복했을때 회복량 + mp > MAX_MP
    @Test
    fun prayOver() {

        // 준비
        val cleric = Cleric(name = "아서스", hp = 50, mp = 5)

        // 입력할 praySecond
        val praySecond = 6

        // 실행
        val result = cleric.pray(praySecond)

        // 검증
        assertEquals(5, result)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    // 회복했을때 회복량 + mp <= MAX_MP
    @Test
    fun prayNotOver() {
        // 준비
        val cleric = Cleric(name = "아서스", hp = 50, mp = 5)
        val initialMp = cleric.mp

        // 입력할 praySecond
        val praySecond = 3

        // 실행
        val result = cleric.pray(praySecond)

        // 검증
        assertContains((3..5), result)
        assertEquals(initialMp + result, cleric.mp)

    }


    // 생성자 테스트
    @Test
    fun `(A) 인스턴스 테스트`() {
        // 준비
        val clericA = Cleric(name = "아서스", hp = 40, mp = 5)

        // 검증
        clericA.apply {
            assertEquals("아서스", this.name)
            assertEquals(40, this.hp)
            assertEquals(5, this.mp)
        }
    }

    @Test
    fun `(B) 인스턴스 테스트`() {
        // 준비
        val clericB = Cleric(name = "아서스", hp = 35)

        // 검증
        clericB.apply {
            assertEquals("아서스", this.name)
            assertEquals(35, this.hp)
            assertEquals(10, this.mp)
        }
    }

    @Test
    fun `(C) 인스턴스 테스트`() {
        // 준비
        val clericC = Cleric(name = "아서스")

        // 검증
        clericC.apply {
            assertEquals("아서스", this.name)
            assertEquals(50, this.hp)
            assertEquals(10, this.mp)
        }
    }

//    // 이름을 지정하지 않는 경우는 컴파일타임에 에러를 뿜는데 테스트하는게 맞는지 의문이 들었다..
//    @Test
//    fun `(D) 인스턴스화 불가능 테스트`() {
//        assertFailsWith<IllegalArgumentException> {
//
//        }
//    }

}
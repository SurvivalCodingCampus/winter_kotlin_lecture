package day03

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.example.day03.Cleric
import org.example.day4.skills.SelfAidable


class ClericTestKotest : DescribeSpec({
    lateinit var cleric: Cleric

    beforeEach {
        cleric = Cleric("test")
    }

    it("초기 값 테스트") {
        cleric.name shouldBe "test"
        cleric.hp shouldBeInRange 0..Cleric.MAX_HP
        cleric.mp shouldBeInRange 0..Cleric.MAX_MP
        Cleric.MAX_HP shouldBe Cleric.MAX_HP
        Cleric.MAX_MP shouldBe Cleric.MAX_MP
    }

    describe("selfAid") {
        var currentMp = 0
        beforeEach {
            cleric.hp = 0
            currentMp = cleric.mp
            cleric.selfAid()
        }

        it("selfAid() 메소드 실행 후 hp 값이 maxHp 값인 50이여야 한다.") {
            cleric.hp shouldBe Cleric.MAX_HP
        }

        it("selfAid() 메소드 실행 후 mp 값이 5 감소 해야 한다.") {
            cleric.mp shouldBe currentMp - SelfAidable.NEED_MP
        }


        it("selfAid() 메소드 실행 시 mp가 ${SelfAidable.NEED_MP} 보다 낮다면 mp는 변하지 않아야 한다.") {
            val setMp = SelfAidable.NEED_MP - 1

            cleric.mp = setMp

            cleric.selfAid()

            cleric.mp shouldBe setMp
        }
    }
    afterEach {
        // 테스트 실행 후에 실행 되는 코드
    }


    val variableSeconds: Array<Int> = arrayOf(-1, 0, 1)
    describe("pray() 메소드 실행 후 ") {
            var beforeMp = 0
            var recoverMP = 0

            beforeEach {
                beforeMp = cleric.mp
            }
        for (second in variableSeconds) {


            it("recover 값이 0 또는 기도한 시간..시간 + Prayable.RANDOM_COLLECTION_MP_RANGE 값이여야 한다.") {
                recoverMP = cleric.pray(second)
                recoverMP should { it == 0 || it in second..second + SelfAidable.NEED_MP }
            }

            it("mp 값이 증가 하거나 같아야 한다.") {
                beforeMp shouldBeLessThanOrEqual cleric.mp
            }

            it("mp 값이 0 이상 maxMp 값 이하 여야 한다.") {
                cleric.mp shouldBeInRange 0..Cleric.MAX_MP
            }
        }
    }
})


package day03

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.example.day03.Cleric
import kotlin.random.Random


class ClericTestKotest : DescribeSpec({
    lateinit var cleric: Cleric

    beforeEach {
        val hp = Random.nextInt(50)
        val mp = Random.nextInt(10)
        cleric = Cleric("test", hp, mp)
    }

    it("초기 값 테스트") {
        cleric.name shouldBe "test"
        cleric.hp shouldBeInRange 0..50
        cleric.mp shouldBeInRange 0..10
        cleric.maxHp shouldBe 50
        cleric.maxMp shouldBe 10
    }

    describe("selfAid") {
        var currentMp = 0

        beforeEach {
            currentMp = cleric.mp
            cleric.selfAid()
        }

        it("selfAid() 메소드 실행 후 hp 값이 maxHp 값인 50이여야 한다.") {
            cleric.hp shouldBe 50
        }

        it("selfAid() 메소드 실행 후 mp 값이 5 감소 하여야 한다.") {
            cleric.mp shouldBe currentMp - 5
        }

        it("selfAid() 메소드 실행 후 mp 값이 0 이상 maxMp 값인 10이하 여야 한다.") {
            cleric.mp shouldBeLessThanOrEqual cleric.maxMp
        }
    }
    afterEach {
        // 테스트 실행 후에 실행 되는 코드
    }



    describe("pray") {

        val beforeMp by lazy { cleric.mp }

        val recover by lazy { cleric.pray(Random.nextInt(10)) }

        it("pray() 메소드 실행 후 recover 값이 0 이상 12 이하 여야 한다.") {
            recover shouldBeInRange 0..12
        }

        it("pray() 메소드 실행 후 mp 값이 증가 하거나 같아야 한다.") {
            beforeMp shouldBeLessThanOrEqual cleric.mp
        }

        it("pray() 메소드 실행 후 mp 값이 0 이상 maxMp 값인 10이하 여야 한다.") {
            cleric.mp shouldBeInRange 0..cleric.maxMp
        }
    }
})


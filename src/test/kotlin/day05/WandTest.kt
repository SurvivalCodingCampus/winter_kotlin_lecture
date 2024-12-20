package day05

import org.junit.Assert
import org.junit.Test


class WandTest {

    // 지팡이의 이름 3문자 이상
    @Test
    fun `지팡이의 이름 글자수 테스트`() {
        Assert.assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "우드완드", power = 5.0)
            wand.name = "우드"
        }
    }

    // 지팡이의 마력: 0.5 이상 100.0 이하
    @Test
    fun `지팡이의 마력이 범위에 포함 안되는 경우 테스트`() {
        Assert.assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "우드완드", power = 5.0)
            wand.power = 0.4
        }
    }
}
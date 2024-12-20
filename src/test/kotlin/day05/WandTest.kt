package day05

import org.example.day05.Wand
import org.example.day05.WandErrorMsg
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll

class WandTest {
    private lateinit var fireWand: Wand

    @Before
    fun setUp() {
        fireWand = Wand(name = "불의 완드", power = 20.0)
    }

    @Test
    fun `Wand 정상적인 객체 생성`() {
        assertEquals("불의 완드", fireWand.name)
        assertTrue(fireWand.power in 0.5..100.0)
    }

    @Test
    fun `Wand name 길이가 3미만으로 초기화 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wand = fireWand.copy(name = "완드")
        }

        assertEquals(WandErrorMsg.NANE_LENGTH_ERROR, exception.message)
    }

    @Test
    fun `Wand power 잘못된 범위로 초기화 시 예외 발생`() {
        assertAll(
            "power < 0.5, power > 100.0",
            {
                val exception = assertThrows(IllegalArgumentException::class.java) {
                    val wand = fireWand.copy(power = 0.0)
                }
                assertEquals(WandErrorMsg.POWER_ERROR, exception.message)
            },
            {
                val exception = assertThrows(IllegalArgumentException::class.java) {
                    val wand = fireWand.copy(power = 101.0)
                }
                assertEquals(WandErrorMsg.POWER_ERROR, exception.message)
            },
        )
    }

    @Test
    fun `Wand name 길이가 3미만으로 변경 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            fireWand.name = "완드"
        }

        assertEquals(WandErrorMsg.NANE_LENGTH_ERROR, exception.message)
    }

    @Test
    fun `Wand power 잘못된 범위로 변경 시 예외 발생`() {
        assertAll(
            "power < 0.5, power > 100.0",
            {
                val exception = assertThrows(IllegalArgumentException::class.java) {
                    fireWand.power = 0.0
                }
                assertEquals(WandErrorMsg.POWER_ERROR, exception.message)
            },
            {
                val exception = assertThrows(IllegalArgumentException::class.java) {
                    fireWand.power = 101.0
                }
                assertEquals(WandErrorMsg.POWER_ERROR, exception.message)
            },
        )
    }
}
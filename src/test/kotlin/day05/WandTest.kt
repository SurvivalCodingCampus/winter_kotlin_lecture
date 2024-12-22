package day05

import org.example.day05.Wand
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class WandTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `wandConstructorNameIsNull`() {
        /*try {
            val wandAfterNameNull = Wand(null, 5.0)
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }*/
        assertThrows<IllegalArgumentException>("이름이 null일 때 예외가 발생합니다.") {
            Wand(null, 5.0)
        }
    }

    /*@Test(expected = java.lang.IllegalArgumentException::class)
    fun whenInvalidInput_thenThrowException() {
        someMethod(-1) // 이 메소드가 IllegalArgumentException을 던져야 함
    }*/

    @Test
    fun `wandConstructorNameIsTooShort`() {
        /*try {
            val wandAfterNameIsTooShort = Wand("?", 5.0)
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }*/
        assertThrows<IllegalArgumentException>("name is too short") {
            Wand("?", 5.0)
        }
    }
    @Test
    fun `wandConstructorPowerIsNegative`() {
        /*try {
            val wandAfterPowerIsNegative = Wand("common wand", -5.0)
        } catch(e: IllegalArgumentException) {
            println("power is negative")
        }*/
        assertThrows<IllegalArgumentException>("power is negative") {
            Wand("common wand", -5.0)
        }
    }

    @Test
    fun `wandConstructorPowerIsTooStrong`() {
        /*try {
            val wandAfterPowerIsTooStrong = Wand("common wand", 300.0)
        } catch(e: IllegalArgumentException) {
            println("power is too strong")
        }*/
        assertThrows<IllegalArgumentException>("power is too strong") {
            Wand("common wand", 300.0)
        }
    }

    @Test
    fun `wandAfterNameIsNull`() {
        val wandAfterNameNull = Wand("common wand", 5.0)
        /*try {
            wandAfterNameNull.name = null
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }*/
        assertThrows<IllegalArgumentException>("name is null") {
            wandAfterNameNull.name = null
        }
    }

    @Test
    fun `wandAfterNameIsTooShort`() {
        val wandAfterNameIsTooShort = Wand("common wand", 5.0)
        /*try {
            wandAfterNameIsTooShort.name = "?"
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }*/
        assertThrows<IllegalArgumentException>("name is too short") {
            wandAfterNameIsTooShort.name = "?"
        }
    }

    @Test
    fun `wandAfterPowerIsNegative`() {
        val wandAfterPowerIsNegative = Wand("common wand", 5.0)
        /*try {
            wandAfterPowerIsNegative.power = -5.0
        } catch(e: IllegalArgumentException) {
            println("power is negative")
        }*/
        assertThrows<IllegalArgumentException>("power is negetive") {
            wandAfterPowerIsNegative.power = -5.0
        }
    }

    @Test
    fun `wandAfterPowerIsTooStrong`() {
        val wandAfterPowerIsTooStrong = Wand("common wand", 5.0)
        /*try {
            wandAfterPowerIsTooStrong.power = 300.0
        } catch(e: IllegalArgumentException) {
            println("power is too strong")
        }*/
        assertThrows<IllegalArgumentException>("power is too strong") {
            wandAfterPowerIsTooStrong.power = 300.0
        }
    }
}
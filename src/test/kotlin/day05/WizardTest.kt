package day05

import org.example.day05.Wand
import org.example.day05.Wizard
import org.example.day05.WizardErrorMsg
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class WizardTest {
    private lateinit var fireWizard: Wizard

    @Before
    fun setUp() {
        fireWizard = Wizard(
            name = "불 마법사",
            hp = 30,
            mp = 20,
            wand = Wand("불의 완드", 20.0)
        )
    }

    @Test
    fun `Wizard 정상적인 객체 생성`() {
        assertEquals("불 마법사", fireWizard.name)
        assertTrue(fireWizard.hp >= 0)
        assertTrue(fireWizard.mp >= 0)
        assertNotNull(fireWizard.wand)
    }

    @Test
    fun `Wizard name 길이가 3미만으로 초기화 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wizard = fireWizard.copy(name = "법사")
        }
        assertEquals(WizardErrorMsg.NAME_LENGTH_ERROR, exception.message)
    }

    @Test
    fun `Wizard hp 음수 값으로 초기화 시 0으로 변경`() {
        val wizard = fireWizard.copy(hp = -20)
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `Wizard mp 음수 값으로 초기화 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wizard = fireWizard.copy(mp = -20)
        }
        assertEquals(WizardErrorMsg.MP_NEGATIVE_ERROR, exception.message)
    }

    @Test
    fun `Wizard name 길이가 3미만으로 변경 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            fireWizard.name = "법사"
        }
        assertEquals(WizardErrorMsg.NAME_LENGTH_ERROR, exception.message)
    }

    @Test
    fun `Wizard hp 음수 값으로 변경 시 0으로 변경`() {
        val wizard = fireWizard.copy(hp = -20)
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `Wizard mp 음수 값으로 변경 시 예외 발생`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            fireWizard.mp = -20
        }
        assertEquals(WizardErrorMsg.MP_NEGATIVE_ERROR, exception.message)
    }
}
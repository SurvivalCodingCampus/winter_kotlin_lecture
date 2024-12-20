package day05

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*


class WizardTest {
    // 마법사 이름 3글자 이상 테스트
    @Test
    fun `마법사의 이름이 3문자 이상이 아닌 경우 테스트 `() {
        assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "우드완드", power = 50.0)
            val wizard = Wizard(
                name = "간달프",
                hp = 50,
                mp = 50,
                wand = wand
            )
            wizard.name = "슈렉"
        }
    }

    @Test
    fun `마법사의 mp가 0이상이 아닌 경우`() {
        assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "우드완드", power = 50.0)
            val wizard = Wizard(
                name = "간달프",
                hp = 50,
                mp = 50,
                wand = wand
            )
            wizard.mp = -50
        }
    }

    @Test
    fun `Hp가 음수가 되는 상황에서 0이 설정 되는 테스트`() {
        val wand = Wand(name = "우드완드", power = 50.0)
        val wizard = Wizard(
            name = "간달프",
            hp = 50,
            mp = 50,
            wand = wand
        )
        wizard.hp = -50
        assertEquals(0, wizard.hp)
    }
}

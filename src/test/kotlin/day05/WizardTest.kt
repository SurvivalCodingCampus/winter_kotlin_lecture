package day05

import org.hyunjung.day05.Wand
import org.hyunjung.day05.Wizard
import org.junit.Assert.*
import org.junit.Test

class WizardTest {

    private val validWand = Wand(name = "불의 지팡이", power = 10.0)

    @Test
    fun `정상적인 Wizard 생성`() {
        val wizard = Wizard(name = "간달프", hp = 100, wand = validWand)
        assertEquals("간달프", wizard.name)
        assertEquals(100, wizard.hp)
        assertEquals(validWand, wizard.wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `이름이 3문자 미만이면 예외 발생`() {
        Wizard(name = "간달", hp = 100, wand = validWand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `HP가 음수일 때 자동으로 0으로 설정`() {
        val wizard = Wizard(name = "간달프", hp = -10, wand = validWand)
        assertEquals(0, wizard.hp)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `wand가 null이면 예외 발생`() {
        Wizard(name = "간달프", hp = 100, wand = null)
    }

    @Test
    fun `이름 변경 테스트`() {
        val wizard = Wizard(name = "간달프", hp = 100, wand = validWand)
        wizard.name = "해리포터"
        assertEquals("해리포터", wizard.name)
    }

    @Test
    fun `HP 변경 테스트`() {
        val wizard = Wizard(name = "간달프", hp = 100, wand = validWand)
        wizard.hp = 50
        assertEquals(50, wizard.hp)

        wizard.hp = -20
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `wand 변경 테스트`() {
        val wizard = Wizard(name = "간달프", hp = 100, wand = validWand)
        val newWand = Wand(name = "새로운 지팡이", power = 20.0)
        wizard.wand = newWand
        assertEquals(newWand, wizard.wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `wand를 null로 설정 시 예외 발생`() {
        val wizard = Wizard(name = "간달프", hp = 100, wand = validWand)
        wizard.wand = null
    }

    @Test(expected = IllegalArgumentException::class)
    fun `MP가 0미만인 경우`() {
        Wizard(name = "간달프", hp = 100, mp = -1, wand = validWand)
    }
}
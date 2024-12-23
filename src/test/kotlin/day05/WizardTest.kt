package day05

import day06.Hero
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

    @Test
    fun `wizard heal Test`() {
        // 준비
        val wizard = Wizard(name = "간달프", hp = 100, wand = Wand("우드완드", 40.0))
        val hero = Hero(name = "홍길동")
        hero.getDamage(40)              // hero 50 - 40 = 10 이남음

        // 실행
        wizard.heal(hero)

        // 검증
        assertEquals(30, hero.hp)
        assertEquals(90, wizard.mp)
    }

    @Test
    fun `lack mp for use wizard heal`() {
        // 준비
        val wizard = Wizard(name = "간달프", hp = 100, wand = Wand("우드완드", 40.0))
        val hero = Hero(name = "홍길동")
        wizard.mp = 0                           // 마법사의 mp를 0으로 만들어버림
        hero.getDamage(40)              // hero 50 - 40 = 10 이남음

        // 실행
        wizard.heal(hero)

        // 검증
        assertEquals(10, hero.hp)
        assertEquals(0, wizard.mp)
    }
}

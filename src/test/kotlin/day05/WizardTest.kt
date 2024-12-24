package day05

import org.example.day05.Wand
import org.example.day05.Wizard
import org.example.day06.Hero
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    lateinit var wand: Wand
    lateinit var hero: Hero
    lateinit var wizard: Wizard

    @Before
    fun setUp() {
        wand = Wand(name = "지팡이", power = 100.0)
        hero = Hero(name = "히어로", hp = 100)
        wizard = Wizard(name = "wizard", hp = 100, wand = wand)
    }

    @Test
    fun `wizard - mp 초기값은 100 이어야 된다`() {
        assertEquals(100, wizard.mp)
    }

    @Test
    fun `heal - hero의 hp를 20회복 시킨다`() {
        wizard.heal(hero)

        assertEquals(120, hero.hp)
    }

    @Test
    fun `heal - heal을 사용하면 mp를 10 소모한다 `() {

        wizard.heal(hero)

        //기본 mp = 100
        assertEquals(90, wizard.mp)
    }

    @Test
    fun `heal - hero의 MAX_HP를 넘기지 않는다`() {

        wizard.heal(hero)
        assertEquals(120, hero.hp)

        wizard.heal(hero)
        assertEquals(140, hero.hp)

        wizard.heal(hero)
        assertEquals(150, hero.hp)
    }

    @Test
    fun `heal - mp가 10미만이면 hero의 hp는 변하지 않는다`() {
        wizard.mp = 5
        wizard.heal(hero)
        assertEquals(100, hero.hp)

    }
}
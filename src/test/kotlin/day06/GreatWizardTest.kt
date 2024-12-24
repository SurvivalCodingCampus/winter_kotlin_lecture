package day06

import org.example.day05.Wand
import org.example.day06.GreatWizard
import org.example.day06.Hero
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GreatWizardTest {
    lateinit var wand: Wand
    lateinit var hero: Hero
    lateinit var greatWizard: GreatWizard

    @Before
    fun setUp() {
        wand = Wand(name = "지팡이", power = 100.0)
        hero = Hero(name = "히어로", hp = 100)
        greatWizard = GreatWizard(name = "greatWizard", hp = 100, wand = wand)
    }

    @Test
    fun `GreatWizard - mp 초기값은 150 이어야 된다`() {

        assertEquals(150, greatWizard.mp)
    }

    @Test
    fun `superHeal - hero의 hp를 전부 회복시킨다`() {


        greatWizard.superHeal(hero)

        assertEquals(Hero.MAX_HP, hero.hp)
    }

    @Test
    fun `superHeal - superHeal을 사용하면 mp를 50 소모한다 `() {

        greatWizard.superHeal(hero)

        assertEquals(100, greatWizard.mp) //기본 mp = 150
    }

    @Test
    fun `superHeal - hero의 MAX_HP를 넘기지 않는다`() {

        greatWizard.superHeal(hero)
        greatWizard.superHeal(hero)
        assertEquals(Hero.MAX_HP, hero.hp)


    }

    @Test
    fun `superHeal - mp가 50미만이면 hero의 hp는 변하지 않는다`() {
        greatWizard.mp = 30

        greatWizard.superHeal(hero)
        assertEquals(100, hero.hp)

    }


}
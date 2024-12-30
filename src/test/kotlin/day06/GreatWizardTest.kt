package day06

import org.example.day03.Hero
import org.example.day05.Wand
import org.example.day06.GreatWizard
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class GreatWizardTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `GreatWizard 의 superHeal, heal 테스트`() {
        // mp 50 소모해서 hero.hp 전부 회복
        // mp 부족시 마나 부족 출력
        // 슈퍼힐 성공시 힐 시전과 대상 체력 출력
        val hero = Hero("용사", hp = 10)
        val wand = Wand("지팡이", power = 50.0)
        val greatWizard = GreatWizard("대마법사", hp = 50, wand = wand)

        //대마법사의 mp가 150으로 증가
        assertEquals(150, greatWizard.mp)

        // 슈퍼힐 성공후 용사 체력
        // 시작 체력은 10
        greatWizard.superHeal(hero)
        assertEquals(Hero.MAX_HP, hero.hp)

        // 마나가 부족한 경우 슈퍼힐 작동 안하는지 확인
        // 시작 체력은 30
        greatWizard.mp = 49
        hero.hp = 30
        greatWizard.superHeal(hero)
        assertEquals(30, hero.hp)

        // 힐 성공후 용사 체력
        // 시작 체력은 10
        hero.hp = 10
        greatWizard.heal(hero)
        assertEquals(30, hero.hp)

        // 마나가 부족한 경우 힐 작동 안하는지 확인
        // 시작 체력은 30
        greatWizard.mp = 9
        greatWizard.heal(hero)
        assertEquals(30, hero.hp)
    }
}
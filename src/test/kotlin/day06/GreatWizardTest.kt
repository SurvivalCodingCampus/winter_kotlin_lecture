package day06

import day05.Wand
import org.junit.Test

import org.junit.Assert.*

class GreatWizardTest {


    // 슈퍼 힐 테스트
    @Test
    fun `super Heal Test`() {
        // 준비
        val greatWizard = GreatWizard(name = "대마법사", hp = 100, wand = Wand("우드완드", 40.0))
        val hero = Hero(name = "홍길동")
        hero.getDamage(40)      // 히어로에게 40 데미지

        // 실행
        greatWizard.superHeal(hero)

        // 검증
        assertEquals(100, greatWizard.mp)
        assertEquals(Hero.MAX_HP, hero.hp)
    }

    // 슈퍼 힐을 쓰는데 마나가 부족한 경우
    @Test
    fun `lack of mp for superHeal`() {
        // 준비
        val greatWizard = GreatWizard(name = "대마법사", hp = 100, mp = 0, wand = Wand("우드완드", 40.0))
        val hero = Hero(name = "홍길동")
        hero.getDamage(40)      // 히어로에게 40데미지 현재 체력 10

        // 실행
        greatWizard.superHeal(hero)


        // 검증
        assertEquals(0, greatWizard.mp)
        assertEquals(10, hero.hp)
    }
}
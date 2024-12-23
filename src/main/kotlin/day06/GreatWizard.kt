package day06

import day03.Hero
import day05.Wand
import day05.Wizard

/*
GreatWizard 클래스 요구사항:
Wizard 클래스를 상속받음
속성:
mp가 150으로 증가
메서드:
superHeal(hero: Hero): Unit의 hp를 전부 회복시키고 자신의 mp를 50 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
*/

class GreatWizard(name: String, hp: Int, mp: Int = 150, wand: Wand) : Wizard(name, hp, mp, wand) {
    override fun heal(hero: Hero) {
        if (mp < 50) {
            println("마나가 부족합니다")
            return
        } else {
            this.mp -= 50
            hero.takeHp(Hero.MAX_HP)
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }
}

/*
고민
GreatWizard 자신의 mp를 50 소모시켜야 하는데,
this.mp -= 50 가 안된다.
Cannot assign to 'mp': the setter is invisible (private in a supertype) in 'GreatWizard
-> Wizard의 mp를 protected로 바꾸면 자식 클래스에서 해당 변수에 접근하고 수정할 수 있다
*/

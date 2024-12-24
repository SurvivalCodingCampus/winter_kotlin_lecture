package day06

import day03.Hero
import day05.Wand
import day05.Wizard
/*GreatWizard 클래스 요구사항:
Wizard 클래스를 상속받음
속성:
mp가 150으로 증가
메서드:
superHeal(hero: Hero): Unit의 hp를 전부 회복시키고 자신의 mp를 50 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
*/
class GreatWizard(initialName: String, initialHp: Int, mp: Int = 150, wand: Wand) : Wizard(initialName, initialHp, mp, wand) {
    // 상속받기 때문에 GreatWizard의 파라미터를 Wizard클래스의 생성자와 일치시켜야 함

    fun superHeal(hero: Hero): Unit {  //heal할 대상이 hero 참조객체

        if (mp < 50) {
            println("마나가 부족합니다")
        } else {
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
            mp -= 50
            hero.hp = hero.maxHp

        }
    }
}

fun main() {
    val wand = Wand("지팡이", 80.0)
    val greatWizard = GreatWizard("대마법사", 90, wand = wand)
    val hero = Hero("다덤벼", hp = 33)

    println("초기 mp: ${greatWizard.mp}")
    greatWizard.superHeal(hero)
    println("슈퍼힐 이후 HP: ${hero.hp}")
    println("슈퍼힐 이후 mp: ${greatWizard.mp}")

}

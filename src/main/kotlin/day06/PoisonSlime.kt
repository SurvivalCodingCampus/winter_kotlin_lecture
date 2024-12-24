package org.example.day06

import org.example.day05.Wand
import org.example.day05.Wizard

/*
독 슬라임(PoisonSlime) 은, 슬라임 (Slime) 중에서도 특히 “독 공격" 이 되는 것
PoisonSlime 는 아래의 코드로 인스턴스화 되는 클래스임
val poisonSlime = PoisonSlime(“A”);
PoisonSlime은 독 공격 가능 횟수를 저장하는 poisonCount(초기값 5)를 가진다
PoisonSlime attack() 메서드가 호출되면 다음 내용의 공격을 한다
   a. 우선, "보통 슬라임과 같은 공격"을 한다
   b. poisonCount가 0이 아니면 다음을 추가로 수행한다
   c. 화면에 "추가로, 독 포자를 살포했다!"를 표시
   d. 용사의 최대 HP의 1/5에 해당하는 포인트를 용사의 HP로부터 감소시키고, "~포인트의 데미지"라고 표시
   e. poisonCount를 1 감소시킨다

 */

class PoisonSlime(suffix: String) : Slime(suffix) {
    var poisonCount = 5

    override fun attack(hero: Hero) {
        super.attack(hero)
        if (hero.hp < 1) {
            println("독 공격 실패")
            println("Hero의 hp가 없습니다.")
            return
        }

        if (poisonCount > 0) {
            println("추가로, 독 공격 성공")
            println("${hero.hp / 5}포인트의 독 데미지")
            hero.hp -= hero.hp / 5
            println("독 공격 후 남은 hero hp: ${hero.hp}")
            poisonCount -= 1
            println("남은 poisonCount: $poisonCount")
        } else if (poisonCount < 0) {
            println("독 공격 가능 횟수가 부족합니다.")
        }
    }
}

fun main() {
    val poisonSlime = PoisonSlime("A")
    val hero = Hero(hp = 100, name = "용사")

    val wand = Wand(name = "지팡이", power = 100.0)
    val wizard = Wizard(name = "wizard", hp = 100, wand = wand)
    val greatWizard = GreatWizard(name = "greatWizard", hp = 100, wand = wand)



    poisonSlime.attack(hero)
    poisonSlime.attack(hero)
    poisonSlime.attack(hero)
    poisonSlime.attack(hero)
    poisonSlime.attack(hero)
    poisonSlime.attack(hero)

    wizard.heal(hero)
    greatWizard.superHeal(hero)
    greatWizard.superHeal(hero)
    greatWizard.superHeal(hero)
    greatWizard.superHeal(hero)


}
package day06

import day03.Hero
import day03.Slime
import kotlin.time.toDuration

/*독 슬라임(PoisonSlime) 은, 슬라임 (Slime) 중에서도 특히 “독 공격" 이 되는 것
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
class PoisonSlime(suffix: String, hp: Int) : Slime(suffix, hp) {
    var poisonCount = 5

    override fun attack(hero: Hero) {       //hero: Hero는 attack할 대상을 의미

        if (poisonCount == 0) {
            println("독 포자 소진, 공격 불가")
            return
        }

        super.attack(hero)

        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            var damegeHp = hero.maxHp/5
            hero.hp -= damegeHp
            println("${damegeHp}의 데미지")
            poisonCount -= 1
            println("$poisonCount 카운트")
        }
    }
}

fun main() {
    val hero = Hero("다덤벼", hp = 100)
    val poisonSlime = PoisonSlime("악당", 99)

    for (i in 1..8) {
        poisonSlime.attack(hero)
    }
    println(hero.hp)    //todo 마이너스값 처리
}

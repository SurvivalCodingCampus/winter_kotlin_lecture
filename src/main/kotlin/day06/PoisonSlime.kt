package day06

import day03.Hero

/*
Slime 클래스를 이용해, 다음 사양을 따르는 PoisonSlime 클래스를 작성하시오
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

class PoisonSlime(var name: String) : Slime(name) {

    var poisonCount = 5 // 테스트해야 해서 private 못함

    override fun attack(hero: Hero) {

        super.attack(hero)

        if (poisonCount > 0) {
            println("추가로 독 포자를 살포했다!")
            val damage = (Hero.MAX_HP * 0.2).toInt()
            hero.takeDamage(damage)
            println("$damage 포인트의 데미지")
            poisonCount -= 1
        } else {
            println("공격용 독이 남아있지 않습니다.")
        }

    }

}

/*
고민
1.요구사항의 hero의 최대HP가 뜻하는 바가 현재 가지고 있는 최대HP인지 hero가 가질수있는 MAX_HP인지 헷갈려서 우선 hero 클래스에 MAX_HP를 추가하여 구현함

 2.데미지 받은 후 히어로의 hp가 음수가 될 수 없는데 이 로직을 Slime 클래스에서 처리해야할지 hero에서 처리해야할지 고민함
 히어로의 상태를 슬라임에서 수정하는건 히어로의 캡슐화를 위반하게 되는것인가?
 슬라임 클래스에서 hero 공격시 hero의 hp를 깎는 것도 마찬가지로 이상해 보이기 시작하여 hero가 damage받아 hero클래스에서 hp깎이게 구현함
 hero.hp -= damage 를 hero 메서드 인수에 damage를 전달하는 것으로
 */




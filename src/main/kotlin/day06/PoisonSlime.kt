package day06

/*
* 독 슬라임 구현
* Slime 중에서도 '독 공격'이 되는 것
* Posion Slime은 독 공격 가능 횟수를 저장 하는 poisonCount(초기값 5)를 가진다.
* */
class PoisonSlime(
    suffix: String
) : Slime(suffix) {

    // 독 공격 가능 횟수를 저장하는 posionCount
    private var positionCount: Int = 5

    override fun attack(hero: Hero) {
        super.attack(hero)      // 보통 슬라임 공격
        if (positionCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            hero.getDamage(Hero.MAX_HP / 5)
            positionCount -= 1
        }
    }

}

fun main() {
    val poisonSlime = PoisonSlime("A")
    val hero = Hero(name = "홍길동")
    poisonSlime.attack(hero)
}
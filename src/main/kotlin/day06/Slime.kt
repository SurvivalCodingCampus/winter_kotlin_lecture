package day06


open class Slime(private val suffix: String) {
    var hp = 50
        private set

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다.")
        println("10의 데미지")
        hero.getDamage(10)
    }
}
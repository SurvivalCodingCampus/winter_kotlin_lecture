package day06


open class Slime(private val suffix: String) {
    // 추후에 누군가 슬라임을 공격하면 데미지 메소드를 추가할수있게 외부 set만 제한하도록 함
    var hp = 50
        private set

    open fun attack(hero: Hero) {

        if (hero.isDead) return

        println("슬라임 $suffix 가 공격했다.")
        println("${SLIME_ATTACK_DAMAGE}의 데미지")
        hero.getDamage(SLIME_ATTACK_DAMAGE)

    }

    companion object {
        const val SLIME_ATTACK_DAMAGE = 10
    }
}
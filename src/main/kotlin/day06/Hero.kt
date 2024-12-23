package day06

class Hero(
    val name: String
) {
    var hp: Int = MAX_HP
        private set

    var isDead: Boolean = false
        private set

    // 호출되면 영웅이 데미지를 받는 코드
    fun getDamage(damage: Int) {
        if (hp > 0) {
            hp = (hp - damage).coerceAtLeast(0)     // 체력이 0 아래로 떨어질경우 0으로 처리
            println("${damage}포인트의 데미지")
        }
        // hp가 0일 경우 사망 처리
        if (hp == 0) die()
    }


    // 마법사로부터 힐을 받으면 호출
    fun getHeal(healAmount: Int) {
        if (hp + healAmount > MAX_HP) {
            hp = MAX_HP
        } else {
            hp += healAmount
        }

    }

    private fun die() {
        isDead = true
        println("히어로가 사망했습니다.")
    }

    companion object {
        const val MAX_HP = 50       // 용사의 최대 HP
    }
}

package org.example.day06


class Hero(name: String, var hp: Int = MAX_HP, var sword: Sword? = null) {
    var name: String = name
        private set


    init {
        require(name.length > 1) { "이름이 너무 짧습니다" }
        require(name.length < 8) { "이름이 너무 깁니다" }
        this.name = name
    }



    fun bye() {
        println("빠이")
    }

    private fun die() {
        println("죽었다")
    }

    fun attack(slime: Slime) {
        if (hp <= 0) {
            println("hp 부족으로 공격할 수 없습니다")
            return
        }
        hp -= HP_BY_ATTACK
        println("$name 이 ${slime.suffix}을 공격했다")
        println("슬라임의 반격을 받았다")
    }

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }

    companion object {
        const val HP_BY_ATTACK = 10
        const val MAX_HP = 150
    }
}

class Sword(val name: String, val damage: Int)
package day03

import day06.Slime


class Sword(val name: String, val damage: Int)

class Hero(name: String, var hp: Int, var sword: Sword? = null) {
    var name: String = name
        private set

    init {
        require(name.length > 1) { "이름이 너무 짧습니다" }
        require(name.length < 8) { "이름이 너무 깁니다" }
        this.name = name
    }

    companion object {
        const val MAX_HP = 100
        const val HP_BY_ATTACK = 10
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

    fun takeDamage(damage: Int) {
        hp = (hp - damage).coerceAtLeast(0) // HP가 0보다 작아지지 않음
    }

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
}

class Inn {
    fun checkIn(hero: Hero) {
        // hero.hp = -100 // 논리적으로 말이 안 됨. Hero var hp를 private으로 접근 제한
    }
}

class King {
    fun callHero(hero: Hero) {
        println("용사님, 저희 왕국에 와주셔서 감사합니다!")
        println("용사님의 이름은 ${hero.name}이고 hp는 ${hero.hp}입니다 ")
        // hero.die() // 이럼 안 되지~ die()메소드를 private으로 제한
    }
}


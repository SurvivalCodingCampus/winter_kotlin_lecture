package org.example.day03

import org.example.day04.Sword
import org.example.day04.Enemy

open class Hero(
    var name: String,
    var hp: Int = MAX_HP,
    var sword: Sword? = null,
) { // 클래스 명 뒤에 괄호가 생성자를 의미한다.

    companion object {
        const val MAX_HP = 50
    }

    open fun attack(enemy: Enemy) {
        if(!enemy.alive) {
            println("이미 처치한 대상입니다.")
            return
        }

        if (sword == null) {
            println("헛방")
        } else {
            enemy.attacked(sword?.damage ?: 0)
        }

    }

    fun getHeal(heal: Int) {
        hp = if( (hp + heal) > MAX_HP) MAX_HP else (hp + heal)
    }

    open fun run() {}
    fun sleep() {}
}


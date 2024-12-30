package org.example.day03

import day08.Character
import org.example.day04.Sword
import org.example.day04.Enemy

open class Hero(
    name: String,
    hp: Int = MAX_HP,
    mp: Int = MAX_MP,
    var sword: Sword? = null,
): Character(name, hp, mp) { // 클래스 명 뒤에 괄호가 생성자를 의미한다.

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 50
    }

    override fun attack(enemy: Enemy) {
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
    override fun defend() {
        TODO("Not yet implemented")
    }
    override fun run() {}

    fun sleep() {}
    fun getHeal(heal: Int) {
        hp = if( (hp + heal) > MAX_HP) MAX_HP else (hp + heal)
    }
}


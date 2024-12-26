package day03

import day06.Attackable
import day07.Character

fun main() {
    val hero = Hero("홍길동", 90)
    //자바는 파라미터 순서 바꾸려면 오버로드 해야하는데, 코틀린은 걍 내가 설정가능(hp=100, name="홍길동")

    val slime = Slime(suffix = "A", hp = 50)
    hero.attack(slime)
    println(hero.hp)
    println(slime.hp)

    hero.sleep()
}

open class Hero (
    name: String,
    hp: Int,
) : Character(name, hp), Attackable { //초기값

    //메소드
    override fun attack(target: Slime) {
        println("${name}이 ${target}을 공격했다" )
        println("슬라임의 반격을 받았다")
        target.hp -= 10
    }

    override fun defend() {
        println("$name 의 방어")
        println("5의 방어력을 얻었다")
    }

    override fun run() {
        println("$name 이 도망쳤다")
    }

    fun sleep() {
        hp = maxHp
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
    fun pung(): String {
        return "뽕"
    }

    companion object {
        const val maxHp: Int = 100
    }
}


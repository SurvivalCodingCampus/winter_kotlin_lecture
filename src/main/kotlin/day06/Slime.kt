package org.example.day06


open class Slime(val suffix: String) {
    var hp = 50

    open fun attack(hero: Hero) {
        if (hero.hp > 0) {
            println("슬라임 $suffix 기본 공격 성공")
            println("10의 기본 데미지")
            hero.hp = if (hero.hp > 10) hero.hp - 10 else 0
            println("기본 공격 후 남은 hero hp: ${hero.hp}")
        } else {
            println("슬라임 $suffix 기본 공격 실패")
            println("Hero의 체력이 없습니다.")
        }

    }
}
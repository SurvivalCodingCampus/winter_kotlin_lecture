package day03

fun main() {
    /* 가상 세계에 용사를 생성
     용사는 이름과 hp를 반드시 가져야 함*/
    val hero = Hero(name = "홍길동", hp = 50)

/*    println(hero.hp)
    hero.sleep()
    println(hero.hp) // 체력 회복 확인*/

    // 슬라임 한마리 생성
    val slime = Slime(hp = 50, suffix = "A")
    println(slime.suffix)
    println(slime.hp)

    slime.run()

}

class Sword(val name: String, val damage: Int)

class Hero(var name: String, private var hp: Int, var sword: Sword? = null) {

    fun bye() {
        println("빠이")
    }

    private fun die() {
        println("죽었다")
    }

    fun attack(slime: Slime) {
        println("$name 이 ${slime}을 공격했다")
        println("슬라임의 반격을 받았다")
        hp -= 10
        if (hp <= 0) {
            die()
        }
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
        // println("용사님의 이름은 ${hero.name}이고 hp는 ${hero.hp}입니다 ")
        // hero.die() // 이럼 안 되지~ die()메소드를 private으로 제한
    }
}

class Slime(var suffix: String, var hp: Int) {
    val level = 10
    fun run() {
        println("슬라임 ${suffix}가 도망갔다")
    }
}

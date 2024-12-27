package org.example.day03

fun main() {
}

open class Hero(
    name: String,
//    private var _hp: Int,
    hp: Int = MAX_HP,
//    var sword: String? = null,
): Comparable<Hero> {
//    private var _hp = hp
    var hp: Int = hp
    set(value) {
        field = if (value > MAX_HP) MAX_HP else value
    }

    var name: String = name
        set(value) {

        }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    // 메소드
    open fun attack() {
        println("hero attack")
    }
    fun run() {

    }

    override fun toString(): String {
        return "Hero(name='$name', hp=$hp)"
    }

    override fun compareTo(other: Hero): Int {
        return hp.compareTo(other.hp)
//        return name.compareTo(other.name)
    }

    // 동등성 규칙 수정
    override fun equals(other: Any?): Boolean {
        return name == (other as Hero).name
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun copy(
        name: String = this.name,
        hp: Int = this.hp,
    ): Hero {
        return Hero(name, hp)
    }


//    fun sleep() {
//        _hp = 100;
//        println("${name}은 잠을 자고 회복했다 : $_hp")
//    }
}
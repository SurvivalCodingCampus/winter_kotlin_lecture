package org.example.day3

fun main() {
}

open class Hero(
    name: String,
//    private var _hp: Int,
    var hp: Int = MAX_HP,
    var sword: String? = null,
) {
//    private var _hp = hp
//    val hp: Int
//            get() = _hp


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

//    fun sleep() {
//        _hp = 100;
//        println("${name}은 잠을 자고 회복했다 : $_hp")
//    }
}
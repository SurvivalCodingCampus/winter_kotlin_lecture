package com.survivalcoding.day06


class Wand(
    var name: String?,
) {

    fun attack() {

    }
}

open class WandTest {
    // 지연 초기화 1
    // 개발자가 안전 보증
    lateinit var fireWand: Wand

    // 최초 사용될 때 초기화
//    val normalWand: Wand by lazy {
//        Wand()
//    }


}

fun main() {

    val wandTest = WandTest()
    val wand = Wand(null)

    // null 이 아님을 보장
    println(wand.name!!.uppercase())

//    println(wand.fireWand.attack())
}
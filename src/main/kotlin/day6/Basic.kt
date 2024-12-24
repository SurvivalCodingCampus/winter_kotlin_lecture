package org.example.day6

class Wand(
    name: String
) {
    var name = require(name.length > 3)
    fun attack() {

    }
}

open class WandTest {
    // 지연 초기화
    // 개발자가 안전 보증
    lateinit var fireWand: Wand

    // 최초 사용될 때 초기화
//    val normalWand: Wand by lazy {
//        Wand()
//    }
}
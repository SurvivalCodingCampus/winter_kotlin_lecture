package com.survivalcoding.com.survivalcoding.day05

fun fireball(damage: Int): Unit {
    println("데미지 : $damage")
}

fun main() {
    var name: String? = "홍길동"

//    val gildong = mapOf(Pair("홍길동", 10))
    val gildong2: Map<String, Any?> = mapOf(
        "홍길동" to 10,
        "한석봉" to 20,
        "한석봉" to "10",
        "한석봉" to "null",
        "한석봉" to null,
    )

    val items: List<Int> = listOf(1, 2, 3, 4, 4, 4)
    val itemSet = items.toSet()

    // (T) -> Unit
    items.forEach { number: Int ->
        println(number)
    }

//    val func = fireball

    items.forEach(::fireball)

    val wizard = Wizard()

    wizard.attack()
    wizard.fireball { damage: Int ->
        println(damage)
    }
}

class Wizard {
    fun attack() {

    }
}

fun damage(num: Int): Unit {

}

// 확장함수
fun Wizard.fireball(damage: (Int) -> Unit) {
    println("파이어볼")
    damage(100)     // 콜백
}
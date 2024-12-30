package org.example.day05

import org.example.day05.Wizard

fun fireball(damage: Int): Unit {
    println("데미지 : $damage")
}

fun main() {
    // 서로 같음 밑에 표현이 더 있어보이는 표현
    val gildong = mapOf(Pair("홍길동", 10))
    val gildong2 = mapOf(
        "홍길동" to 10,
        "한석봉" to 12,
        "전우치" to 13,
    )

    val gildong3: Map<String, Int?> = mapOf(
        "홍길동" to 10,
        "한석봉" to 12,
        "전우치" to null,
    )

    val items: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val item = setOf(1, 2, 3, 4, 4, 6)

    item.forEach { number: Int ->
        println(number)
    }

    items.forEach(::fireball)

//    val wizard = Wizard()
//
//    wizard.attack()
//    wizard.fireball { damage: Int ->
//        println(damage)
//    }
}

fun damage(num: Int): Unit {

}
// 확장함수
fun Wizard.fireball(damage: (Int) -> Unit) {
    println("파이어볼")
    damage(100)
}
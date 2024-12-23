package org.example.day05

fun main() {
    val items: List<Int> = listOf(1, 2, 3, 4)
    items.forEach {
        println(it)
    }

    val wizard = TestWizard()
    wizard.attack()
    wizard.fireball { damage ->
        println(damage)
    }
}

// 확장 함수 예시
class TestWizard() {
    fun attack() {

    }
}

fun TestWizard.fireball(damage: (num: Int) -> Unit) {
    println("파이어볼")
    damage(100) // 콜백함수
}
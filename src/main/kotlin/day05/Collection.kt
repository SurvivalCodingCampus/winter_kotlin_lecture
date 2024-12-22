package day05


fun main() {
    val gildong = mapOf(Pair("name", "홍길동"))
    val gildong2 = mapOf("name" to "홍길동")

    val items: List<Int> = listOf(1, 2, 3, 4)

    items.forEach {
        println(it)
    }

    val test = Test()
    test.fireball { damage ->
        println("파이어볼 발사 $damage")
    }
}

class Man(
    var name: String,
    val hp: Int
)

class Collection

class Test {
    fun attack() {}
}

fun Test.fireball(damage: (Int) -> Unit) {
    damage.invoke(100)
}
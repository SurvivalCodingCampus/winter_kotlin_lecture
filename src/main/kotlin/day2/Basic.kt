package day2

fun main(args: Array<String>) {
    var name = "serim"
    name = "세림"
    val fullname = "손$name"

    val items = listOf("a", "b", "c")
    for (item in items) {
        println(when(item) {
            "b" -> "Banana"
            else -> item
        })
    }

    println(plus5(3))

    // Null Safety
    val name2: String? = null
    val name3: String = ""

    println(name2?.uppercase())
    println(name3.uppercase())

}

fun plus5(x: Int): Int = x + 5


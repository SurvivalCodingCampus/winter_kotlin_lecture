package day11

fun numberConversion() {
    val numString = "10.5"
    val num: Int = try {
        numString.toInt()
    } catch (_: Exception) {
        0
    }
    println(num)
}
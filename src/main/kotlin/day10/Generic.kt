package org.example.day10

fun main() {
    val nums = mutableListOf<Int>(1, 2, 3, 4)   // <Int> 생략가능
    nums.add(10)

    val pocket = Pocket<Int>()

    pocket.put(10)

    println(pocket.get())
}

// ver2
class Pocket<E> {
    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}

//// ver1
//class Pocket {
//    private var _data: Any? = null
//
//    fun put(data: Any) {
//        _data = data
//    }
//
//    fun get() = _data
//}
package day10

import day09.exercise.Book

fun main() {
    val pocket = Pocket<String>()
    pocket.put("아무거나")

    println(pocket.get())


}


class Pocket<E> {

    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}


//class Pocket {
//
//    private var _data: Any? = null
//
//    fun put(data: Any) {
//        _data = data
//    }
//
//    fun get(): Any? = _data
//}

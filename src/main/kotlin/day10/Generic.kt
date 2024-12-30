package org.example.day10


fun main() {
    val nums = mutableListOf(1, 2, 3, 4)
    nums.add(10)

    val pocket = Pocket()
    pocket.put("아무거나")
    println(pocket.get())
}

//제네릭 사용안함
class Pocket {
    private var _data: Any? = null

    fun put(data: Any) {
        _data = data
    }

    fun get(): Any? = _data
}

//제네릭을 사용한 Pocket 클래스1 (대부분 이런 형태)
//class Pocket<E> {
//    private var _data: E? = null
//
//    fun put(data: E) {
//        _data = data
//    }
//
//    fun get(): E? = _data
//}

//제네릭을 사용한 Pocket 클래스2
//class Pocket<E: Book> {
//    private var _data: E? = null
//
//    fun put(data: E) {
//        _data = data
//    }
//
//    fun get(): E? = _data
//}
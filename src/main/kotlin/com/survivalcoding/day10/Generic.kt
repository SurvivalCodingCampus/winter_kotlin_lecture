package com.survivalcoding.com.survivalcoding.day10

fun main() {

    val nums = mutableListOf(1, 2, 3, 4)
    nums.add(10)

    val pocket = Pocket<Int>()

    pocket.put(10)

    println(pocket.get())

    // 정규식 Regular Exeprssion
//    "1,!2,!3".split(

    "aaa" + "bbb"   // "aaabbb"

}

// ver2
class Pocket<E> {
    private var _data: E? = null

    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data

    fun get2(a: E): E {
        return a
    }
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
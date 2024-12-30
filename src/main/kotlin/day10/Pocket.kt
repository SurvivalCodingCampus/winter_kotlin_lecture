package org.example.day09

import org.example.day07.Book

// top level 에 있을 때의 제네릭
fun <T> get(a: T): List<T> = listOf<T>()

//ver1
//
//class Pocket {
//    private var _data: Any? = null
//
//    fun put(data: Any) {
//        _data = data
//    }
//
//    fun get(): Any? =  _data
//}

// ver2 - 일반적으로 자주 사용 되는 형식
class Pocket<E> {
    private var _date: E? = null

    fun put(data: E) {
        _date = data
    }

    fun get() = _date
}

//ver3
//class Pocket<E : Book> {
//    private var _date: E? = null
//
//    fun put(data: E) {
//        _date = data
//    }
//
//    fun get() = _date
//}


// in, out 개념이 있지만 크게 사용하지 않음
// in: 쓰기 전용 = <out E>
// out: 읽기 전용 = <in E>
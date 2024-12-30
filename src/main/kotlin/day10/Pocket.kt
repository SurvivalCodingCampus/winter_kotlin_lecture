package org.example.day10

import org.example.day09.Book
import org.intellij.lang.annotations.JdkConstants.AdjustableOrientation

// 제네릭을 사용하지 않은 클래스
//class Pocket {
//    private var _data: Any? = null
//    fun put(data:Any){
//        _data = data
//    }
//
//    fun get(): Any? = _data
//}

// 제네릭 사용
//class Pocket<E> {
//    private var _data: E? = null
//    fun put(data: E) {
//        _data = data
//    }
//
//    fun get(): E? = _data
//}

// 이용 가능한 타입에 제약을 추가한 Pocket 클래스
class Pocket<E:Book> {
    private var _data: E? = null
    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}
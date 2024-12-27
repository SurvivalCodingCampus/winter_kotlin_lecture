package org.example.day08

fun main() {
    // 연습문제 2-1
    val obj: X = A()

    obj.a()     // X로 그룹핑을 해서 a()만 호출가능
//    obj.b()   // Y로 그룹핑을 하면 a(), b() 호출가능
//    obj.c()   // A로 그룹핑을 하면 모두 호출가능

    // 연습문제 2-2
    val y1: Y = A()
    val y2: Y = B()

    y1.a()
    y2.a()


}

class A : Y() {
    override fun b() {
        println("Ab")
    }

    override fun a() {
        println("Aa")
    }

    fun c() {
        println("Ac")
    }
}

class B : Y() {
    override fun b() {
        println("Bb")
    }

    override fun a() {
        println("Ba")
    }

    fun c() {
        println("Bc")
    }
}

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}


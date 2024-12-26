package org.example.day08

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}

class A : Y() {
    override fun a() {
        println("Aa")
    }

    override fun b() {
        println("Ab")
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

fun main() {
    listOf<Y>(
        A(),
        B(),
    ).forEach {
        it.b()
    }
}
package day08

interface X {
    fun a()
}

abstract class Y: X {
    abstract fun b()
}

class A: Y() {
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

class B: Y() {
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
    val obj: X = A()    // 1. 일단 자료형은 X이므로 X의 멤버함수인 a()가 호출될 것으로 예상
    obj.a()

    val y1: Y = A()
    val y2: Y = B()
    // 2. 오버라이딩 된 함수를 호출하므로 각 실제 자료형에 맞는 멤버함수가 호출될 것이다.
    y1.a()
    y2.a()

    // 3. b를 호출할 수 있는 Y를 타입으로 해야한다.
    var list: List<Y> = listOf(A(), B())

    for(y in list) {
        y.b()
    }
}
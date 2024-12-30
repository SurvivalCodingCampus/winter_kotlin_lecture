package day08

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

fun main() {
    val obj: X = A()
    obj.a()     //Aa
    // b() 또는 c()는 호출 불가. X타입에 a()만 있기 때문.

    val y1: Y = A()
    val y2: Y = B()
    y1.a()      //Aa
    // A 클래스에서 구현된 a() 호출
    y2.a()      //Ba
    // B 클래스에서 구현된 a() 호출
}
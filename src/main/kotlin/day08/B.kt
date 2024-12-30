package day08

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

/**
 * List 의 요소를 차례대로 꺼내 각각의 인스턴스의 b() 메소드를 호출 하여야 한다. 이상을 전제로 다음 물음에 답하시오.
 * List 변수의 타입으로 무엇을 사용하여야 하는가
 * 위에서 설명하고 있는 프로그램을 작성하시오
 */
fun main() {
    val sampleA: Y = A()
    val sampleB: Y = B()
    val list = listOf(sampleA, sampleB)
    list[0].b()
    list[1].b()
}

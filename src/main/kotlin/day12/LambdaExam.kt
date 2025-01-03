package day12

fun main() {
    // 함수를 값으로 전달함
    val list = listOf(1, 3, 2)
    list.forEach(::printElement)  // 132

    list.forEach { e -> print("꺄 $e ")}  // 꺄 1 꺄 3 꺄 2

    // 함수를 값에 저장 - 함수 내용을 바로 정의해서 사용
    val loudify = { msg : String -> "!!! ${msg.uppercase()} !!!" }
    println(loudify("hello"))  // !!! HELLO !!!

    // SAM(Single Abstract Method)
    list.sortedWith(object: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    })

    // 함수가 하나만 있는 인터페이스는 람다로 변경 가능
    val result = list.sortedWith { o1, o2 -> o1 - o2 }
    println(result)  // [1, 2, 3]


}

fun printElement(element: Int) {
    println(element)
}

package day02


fun main() {
    println("Hello World")
    // 상수
    val number = 10f

    // 변수
    var name = "홍길동"
    name = "한석봉"

    val items = listOf("banana", "apple", "kiwi")

    for (item in items) {
        println(item)
    }

    items.forEach { item ->
        println(item)
    }

    println(items)

    val result = sum(3, 5)
    println(result)

    "문장 잘 출력되닝?".printSentence()

    // 더하기 변형
    val sumResult = 30.printSum(40)
    println(sumResult)


    "반복 해서 출력 해버려!".repeatSentence(5)
}

fun sum(a: Int, b: Int) = a + b

// 확장함수
// 문장 출력
fun String.printSentence() {
    println(this)
}


// 입력 받은 카운트 만큼 반복 출력
fun String.repeatSentence(count: Int) {
    repeat(count) {
        println(this)
    }
}

// 지정한 숫자와 입력받은 숫자 더해서 리턴
fun Int.printSum(number: Int): Int {
    return this + number
}



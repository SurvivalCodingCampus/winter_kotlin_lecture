package day02

fun main() {
    println("Hello World")

    // 상수(특별한 일이 없으면 상수로 쓰자)
    val number = 10

    // 변수
    var name = "홍길동"
    name = "한석봉"

    println(plus5(10))

    printSum(1,2)

    val fullName = "홍$name"
    val fullName2 = "이름: ${fullName}"
    println(fullName2)

    val a = 10
    val b = 5


    // if
    val c = if (a > b) a else b

    // else statement
    val d = if (a > b) a else {
        b
    }

    // if statement
    val e = if (a > b) {
        a
    } else {
        b
    }


    // for, list
    val items = listOf("apple", "banana") // list 한 번 세팅되면 수정 안 됨. Java와 달리 List에 add가 안 됨
    println(items)

    for (item in items) {
        println(item)
    }


    // when. Any는 모든 타입을 허용. 가급적 쓰지 말라
    fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }


    // val name2: String = null // Null can not be a value of a non-null type String
    val name3: String? = null // ? 붙이면 됨

    val name4: String = ""
    // println(name3.uppercase()) // name3가 null일 수 있기에 uppercase 사용 안 되게 막힘
    println("null일까? ${name3?.uppercase()}") // ? 붙이면 됨

}

// f(x) = x + 5
// f(5) = 25
fun plus5(x: Int): Int {
    return x + 5
}

// return 없는 함수식
fun printSum(a: Int, b: Int) = println(a + b)




package org.example.day02

fun main() {
    println("Hello World")

    //상수
    val number = 10

    //변수
    var name = "길동"
    name = "석봉"

    println(plus5(10))

    val fullName = "홍$name" //중괄호 있을 때는 변수로 사용 가능

    val a = 10
    val b = 5
    val c = if (a > b) a else b

    val items : List<String> = listOf("apple", "banana")
    println(items)

    for (item in items){
        println(item)
    }

    val name2: String? = null
    val name3: String = ""

    println(name2?.uppercase())
    println(name3.uppercase())
}



// f(x) = x + 5;
// f(5) = 25;
// f(3) = ?;

//fun plus5(x: Int): Int {  "{" 앞에서 alt + enter로 아래 처럼 한줄로 가능
//    return x + 5
//}
fun plus5(x: Int): Int = x + 5

fun printSum(a: Int, b: Int): Unit {// 자바에서의 void와 같음

}
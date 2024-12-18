package day02

fun main() {
    println("Hello")
    //상수
    val number = 10       //val number : Int = 10     타입 생략 가능
    //변수
    var name = "홍길동"    //var name : String = "홍길동"
    name = "한석봉"

    println(sum(10))

    val fullName = "홍$name"
    val fullName2 = "홍${name.length + 10}"
    println(fullName)
    println(fullName2)

    val a=10
    val b=5
    val c= if(a>b) a else b //삼항 연산자 대체
    println(c)

    val items = listOf("apple","banana")    //코틀린은 불변이 기본이라 수정 안됨. 자바는 수정가능
    println(items)

    for (item in items){
        println(item)
    }

    val name2:String? = null
    val name3:String = ""

    //null safety 널 안정성
    println("여기${name2?.uppercase()}")
    println(name3.uppercase())
    println("빈 문자열: '${name3.uppercase()}'") //빈 문자열도 정상적인 값이므로 Kotlin에서는 문제 없이 처리

}
fun sum(x: Int) : Int {
    return x+5
}

//fun sum(x: Int) : Int = x+5      리턴타입 생략 가능

fun printSum(a:Int, b:Int): Unit{       // java의 void가 unit (생략가능)
    println(a+b)
}


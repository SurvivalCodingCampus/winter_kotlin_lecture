package day11.exercise.exception

/*
* 연습문제 1
* 다음과 같은 프로그램을 작성 실행 runtime Error 발생
*
* 연습문제 2
* 연습1에서 작성한 코드를 수정하여 try-catch()문을 사용하여 예외 처리를 하시오 .
* 예외처리에는 다음의 처리를 수행하시오 .
*
* 예외가 발생하면 0으로 처리
* */


fun main() {

    // 1 번 방법 : try - catch
    val numString = "10.5"

    val result = try {
        numString.toInt()
        println("변환 성공!: $numString")
    } catch (e: NumberFormatException) {
        println("변환 실패 : ${e.message}")
        0
    }

    println(result)


    // 2번 방법: runCatching
    val numStringSecond = "10.5"

    val resultSecond = runCatching { numStringSecond.toInt() }
        .getOrElse { exception ->
            println("변환 실패 : $exception")
            0
        }

    println(resultSecond)
}
package day11


/*
* 예외
* */
fun main() {
    try {
        someError()
    } catch (e: Exception) {
        print(e.message)
    }
}


fun someError() {
    throw Exception("에러가 발생하였습니다.")
}
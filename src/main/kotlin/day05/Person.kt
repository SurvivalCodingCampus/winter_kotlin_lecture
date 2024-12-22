package day05

import utils.CommonUtils
import utils.CommonUtils.getCurrentDate
import utils.CommonUtils.getCurrentYear
import utils.SystemFunction
import java.text.SimpleDateFormat
import java.util.*

/*
* Person 클래스 작성
* 1. 이름과 태어난 해를 생성자로 받는다(name, birthYear)
* 2. 이름과 태어난 해는 한번 정해지면 수정이 불가능 하다.
* 3. age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능 하다.
* 4. 나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴
* */
class Person(
    private val name: String,
    private val birthYear: Int,
) : SystemFunction {
    val age: Int
        get() {
            val currentYear = getCurrentYear()
            return currentYear - birthYear
        }

    override fun showStatus() {
        println("----- 상태 출력 -----")
        println("name: ${this.name}, birthYear: ${this.birthYear}, age: ${this.age}")
    }
}

fun main() {
    val person = Person(name = "홍길동", birthYear = 1995)
    person.showStatus()
}
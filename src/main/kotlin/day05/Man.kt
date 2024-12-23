package day05

import java.util.*

/*
이름과 태어난 해를 생성자로 받는다 (name, birthYear)
이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
 */
class Man(val name: String, val birthYear: Int) {
    val age: Int
        get() = calculateAge()

    private fun calculateAge(): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return currentYear - birthYear
    }
}

fun main() {
    val man = Man(name = "지창욱", birthYear = 1987)
    println(man.age)
}
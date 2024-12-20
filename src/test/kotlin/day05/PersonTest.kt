package day05

import org.junit.Test

import org.junit.Assert.*

class PersonTest {

    @Test
    fun getAge() {
        // 준비
        val personFirst = Person(name = "홍길동", birthYear = 1995)
        val personSecond = Person(name = "임꺽정", birthYear = 0)
        val personThird = Person(name = "신사임당", birthYear = -24)

        // 검증
        assertEquals(29, personFirst.age)
        assertEquals(2024, personSecond.age)
        assertEquals(2048, personThird.age)
    }
}
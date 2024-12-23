package day05

import org.junit.Test

import org.junit.Assert.*

class PersonTest {

    @Test
    fun getAge() {
        // 준비
        val personFirst = Person(name = "홍길동", birthYear = 1995)

        // 검증
        assertEquals(29, personFirst.age)
    }
}
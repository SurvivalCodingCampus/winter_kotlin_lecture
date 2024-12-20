package day5

import org.example.day5.Person
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PersonKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `연습문제 2번 테스트`() {
        var person1 = Person("홍길동")
        var person2 = Person("한석봉")
        val persons: List<Person> = listOf(person1, person2)

        assertEquals("홍길동", persons[0].name)
        assertEquals("한석봉", persons[1].name)
    }
}
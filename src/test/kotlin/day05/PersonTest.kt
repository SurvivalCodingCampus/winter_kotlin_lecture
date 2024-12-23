package day05

import org.hyunjung.day05.Person
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class PersonTest {

    @Test
    fun `이름과 태어난 해로 Person 생성`() {
        val person = Person(name = "홍길동", birthYear = 1995)
        assertEquals("홍길동", person.name)
        assertEquals(1995, person.birthYear)
    }

    @Test
    fun `나이 계산은 올해년도에서 birthYear를 뺀 값을 리턴`() {
        val currentYear = LocalDate.now().year
        val person = Person(name = "홍길동", birthYear = 1995)
        assertEquals(currentYear - 1995, person.age)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `태어난 해가 현재 연도보다 큰 경우 예외 발생`() {
        val nextYear = LocalDate.now().year + 1
        Person(name = "홍길동", birthYear = nextYear)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `이름이 비어있으면 예외 발생`() {
        Person(name = "   ", birthYear = 1995)
    }
}
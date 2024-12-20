package day05

import org.example.day05.PersonAType
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class PersonATypeTest {

    @Test
    fun `올바른 나이 계산`() {
        val year = LocalDateTime.now().year
        val person = PersonAType("홍길동", 2000)
        assertEquals(year - 2000, person.age)
    }

    @Test
    fun `길이가 0이하인 이름 입력`() {
        assertThrows(IllegalArgumentException::class.java) {
            val person = PersonAType("", 1997)
        }
    }

    @Test
    fun `birthYear 현재 년도와 200년 이상 차이 날 경우`() {
        assertThrows(IllegalArgumentException::class.java) {
            val person = PersonAType("홍길동", 1820)
        }
    }
}
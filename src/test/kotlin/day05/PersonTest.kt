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

    @Test
    fun `Person을 List에 저장`() {
        val personList = listOf(
            Person("홍길동", 1995),
            Person("한석봉", 1990)
        )
        assertEquals(2, personList.size)
        assertEquals("홍길동", personList[0].name)
        assertEquals("한석봉", personList[1].name)
    }

    @Test
    fun `List에 담긴 모든 Person의 이름 표시`() {
        val personList = listOf(
            Person("홍길동", 1995),
            Person("한석봉", 1990)
        )
        val names = personList.map { it.name }
        assertEquals(listOf("홍길동", "한석봉"), names)
    }

    @Test
    fun `Person의 이름과 나이를 지정된 형식으로 출력`() {
        val personList = listOf(
            Person("홍길동", 2004),
            Person("한석봉", 1999)
        )

        val expectedOutput = listOf(
            "홍길동의 나이는 20살",
            "한석봉의 나이는 25살"
        )

        val actualOutput = personList.map { "${it.name}의 나이는 ${it.age}살" }
        assertEquals(expectedOutput, actualOutput)
    }
}
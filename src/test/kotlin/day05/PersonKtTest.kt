package day05

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
    fun `캡슐화 연습문제 2번 테스트`() {
        var person = Person("김진현", 1999)

        assertEquals("김진현", person.name)
        assertEquals(1999, person.birthYear)
        // 만약에 2025년이면 테스트 결과가 일정하지 않기에
        // 사실상 테스트 불가다
        assertEquals(25, person.age)
    }

//    @Test
//    fun `연습문제 2번 테스트`() {
//        var person1 = Person("홍길동")
//        var person2 = Person("한석봉")
//        val persons: List<Person> = listOf(person1, person2)
//
//        assertEquals("홍길동", persons[0].name)
//        assertEquals("한석봉", persons[1].name)
//    }
//
//    @Test
//    fun `연습문제 3번 테스트`() {
//        var person1 = Person("홍길동")
//        var person2 = Person("한석봉")
//        val personMap: Map<String, Int> = mapOf(
//            person1.name to 20,
//            person2.name to 25,
//        )
//
//        for ((key, value ) in personMap){
//            when (key) {
//                "홍길동" -> assertEquals("\"홍길동의 나이는 20살\"", "\"${key}의 나이는 ${value}살\"")
//                "한석봉" -> assertEquals("\"한석봉의 나이는 25살\"", "\"${key}의 나이는 ${value}살\"")
//            }
//        }
//    }
}
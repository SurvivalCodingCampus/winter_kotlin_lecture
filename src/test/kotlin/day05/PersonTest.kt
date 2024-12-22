package day05

import org.junit.Assert.*
import org.example.day05.Person
import java.time.LocalDate
import kotlin.test.assertContains

class PersonTest {
    @org.junit.Test
    fun `check Person's age`() {
        val person = Person("who are you", 2000)

        val expectedAge = LocalDate.now().year - person.birthYear
        assertEquals(expectedAge, person.age)
    }

    /* 컬렉션 연습문제 1번
    *  1) Set이 적당해 보입니다.
    *       -> 우선 중복이 없게 데이터를 받아줘야 좋을 듯 싶어 List는 제외.
    *       -> 데이터의 종류가 도시 이름이라는 한 종류이므로 Map을 제외하여
    *       -> Set으로 선택하였습니다.
    *  2) List가 적당해 보입니다.
    *       -> 점수는 동일한 점수도 있을 수 있으므로
    *       -> 점수만을 담으려고 한다면 List가 적당해 보입니다.
    *  3) Map이 적당해 보입니다.
    *       -> 도시의 이름은 중복이 없게 받아줘야 좋을 듯 하니 key로 받아주고
    *       -> 인구 수는 중복이 될 수 있으므로 value로 잡아주면 될 듯 합니다.
    * */
    @org.junit.Test
    fun `Person Class Test with Collection`() {
        // 컬렉션 연습문제 2번
        val person1 = Person("홍길동", 2004)
        val person2 = Person("한석봉", 1999)

        val list = listOf<Person>(person1, person2)

        /*val stringBuilder = StringBuilder("")

        for(person in list) {
            stringBuilder.appendLine("who are you: ${person.name}")
        }
        println(stringBuilder)
        */
        assertEquals(2, list.size)
        assertTrue(list.any { it.name == "홍길동" })
        assertTrue(list.any { it.name == "한석봉" })


        // 컬렉션 연습문제 3번
        val personInfo = mapOf(
            person1.name to person1.age,
            person2.name to person2.age,
        )

        /*personInfo.entries.forEach {
            println("name: ${it.key}, age: ${it.value}")
        }*/
        assertEquals(2, personInfo.size)
        assertTrue(personInfo.containsKey("홍길동"))
        assertTrue(personInfo.containsKey("한석봉"))
    }

}
package day07

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PersonTest {

    @Test
    fun `이름 일치 및 리스트에 인스턴스 포함`() {
        val p1 = Person("홍길동")
        val p2 = Person("한석봉")
        val nameList = arrayListOf(p1, p2)

        assertEquals("홍길동", p1.name)
        assertEquals("한석봉", p2.name)
        assertTrue(nameList.contains(p1))
        assertTrue(nameList.contains(p2))
    }

    @Test
    fun `toString 이름 반환`() {
        val p1 = Person("홍길동")
        assertEquals("홍길동", p1.toString())

        val p2 = Person("한석봉")
        assertEquals("한석봉", p2.toString())
    }

    @Test
    fun `이름 나이 쌍 컬렉션의 이름과 나이 출력`() {
        val p1 = Person("홍길동")
        val p2 = Person("한석봉")
        val nameList = mapOf(p1 to 20, p2 to 25)

        val expectedOutput = mutableListOf<String>()

        for (p in nameList) {
            var result = "${p.key}의 나이는 ${p.value}살"
            println(result)
            expectedOutput.add(result)
        }

        assertEquals(listOf("홍길동의 나이는 20살", "한석봉의 나이는 25살"), expectedOutput)
    }

}

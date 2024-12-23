package day05

import org.junit.Test

import org.junit.Assert.*

class PersonTest {

    @Test
    fun getName() {
        val hong = Person("홍길동")
        val han = Person("한석봉")
        assertEquals("홍길동", hong.name)
        assertEquals("한석봉", han.name)
    }

    @Test
    fun testPersonList() {
        val hong = Person("홍길동")
        val han = Person("한석봉")

        val personList = listOf(hong, han)
        assertEquals("홍길동, 한석봉", personList.joinToString())
    }

    @Test
    fun testPersonMap() {
        val hong = Person("홍길동")
        val han = Person("한석봉")

        val goodPerson = mapOf(
            hong to 20,
            han to 25
        )

        assertTrue(goodPerson.keys.containsAll(listOf(hong, han)))
        assertTrue(goodPerson.values.containsAll(listOf(20, 25)))

    }

}
package day05

import Person
import org.example.day03.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows


class WizardTest {
    @Test
    fun `Wizard Test`(): Unit = assertAll(
        "Wizard hp test",
        {
            val wizard = Wizard(name = "성", hp = -4)
            assertEquals(0, wizard.hp)
        },
        {
            val wizard = Wizard(name = "성", hp = 0)
            assertEquals(0, wizard.hp)
        },
        {
            val wizard = Wizard(name = "성", hp = 300)
            assertEquals(300, wizard.hp)
        },
    )

    @Test
    fun `Wand input Test`(): Unit = assertAll(
        "sec > 0, sec == 0, sec < -1",
        {
            assertThrows<IllegalArgumentException> {
               Wand(name = "성", magicDamage = 0.3)
            }
        },
        {
            assertThrows<IllegalArgumentException> {
                Wand(name = "아름다운기사단장님", magicDamage = 103.3)
            }
        },
    )
}


class PersonTest {
    @Test
    fun `Person Test`(): Unit = assertAll(
        "Calc Age",
        {
            val whoAmI = Person(name = "성", birthYear = 1997)
            assertEquals(27, whoAmI.age)
            assertEquals("성", whoAmI.name)
        },
        {
            val whoAmI = Person(name = "성", birthYear = 1997)
            assertEquals(27, whoAmI.age)
            assertEquals("성", whoAmI.name)

//            whoAmI.age = 30
//            whoAmI.name = "ehllo"
//            whoAmI.birthYear = 1944

        },
        {
            val hong = Person(name = "홍길동", age = 30)
            val han = Person(name = "한석봉")

            val nameOfList = mutableListOf<String>(hong.name, han.name)


            assertEquals("홍길동", nameOfList[0])
            assertEquals("한석봉", nameOfList[1])

//            nameOfList.forEach(::println)
//            nameOfList.forEach { name ->
//                println(name)
//            }

        },
        {
            val hong = Person(name = "홍길동", age = 20)
            val han = Person(name = "한석봉", age = 30)

//            println(listOfAges)
//            listOfAges.forEach(::println)

            val listOfAges = setOf<Person>(han, hong)

            listOfAges.forEach { person ->
                println("${person.name}의 나이는 ${person.age}살")
            }

            val iterator = listOfAges.iterator()

            iterator.forEach { person ->
                println("${person.name}의 나이는 ${person.age}살")
            }
        }
    )
}

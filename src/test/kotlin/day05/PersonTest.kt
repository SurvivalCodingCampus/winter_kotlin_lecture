package day05

import org.junit.Test
import kotlin.test.assertEquals
import java.time.LocalDate

class PersonTest {

 @Test
 fun `나이를 get 시점에 탄생년도로부터 계산한다`() {
  val currentYear = LocalDate.now().year
  val birthYear = 2000
  val person = Person("tester", birthYear)

  assertEquals(currentYear - birthYear, person.age)
 }

}

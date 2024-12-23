package day05

import org.junit.Test

import org.junit.Assert.*
import java.util.Calendar

class ManTest {

@Test
 fun getBirthYear() {
  val birthYear = 1987
  val currentYear = Calendar.getInstance().get(Calendar.YEAR)
  val age = currentYear - birthYear

  assertEquals(37, age)
 }
}
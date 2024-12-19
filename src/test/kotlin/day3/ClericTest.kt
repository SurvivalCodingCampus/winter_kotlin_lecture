package day3

import org.example.day3.Cleric
import org.junit.After
import org.junit.Before
import org.junit.Assert.*

class ClericTest {

 @Before
 fun setUp() {}

 @After
 fun tearDown() {}

 @org.junit.Test
 fun selfAId() {
  val cleric = Cleric(name = "사제")

  for (i in 1..5) {
   cleric.selfAid()
   cleric.hp -= 100
  }

  assertEquals(100, cleric.hp)
 }

 @org.junit.Test
 fun pray() {
  val cleric = Cleric(name = "사제")

  assertTrue(cleric.pray(3) in 3..5)
 }
}
package day3

import org.example.day3.Cleric
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

 class ClericTest {

 @Before
 fun setUp() {}

 @After
 fun tearDown() {}

  @Test
  fun selfAId() {
   var cleric = Cleric(name = "사제")

   cleric.selfAId()

   assertEquals(200, cleric.hp)
  }

 }
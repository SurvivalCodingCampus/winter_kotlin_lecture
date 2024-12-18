package day03

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
 fun selfAid() {
   // 준비
   val cleric = Cleric("홍길동", hp = 30, mp = 10)
   val cleric2 = Cleric("기러기", hp = 30, mp = 4)

   // 실행
   cleric.selfAid()
   cleric2.selfAid()

   // 회복 확인
   assertEquals(50, cleric.hp)
   assertEquals(5, cleric.mp)

   // 미회복 확인
   assertEquals(30, cleric2.hp)
   assertEquals(4, cleric2.mp)
 }

@Test
 fun pray() {
 // 준비
 val cleric = Cleric("홍길동", mp = 5)

 // 실행
 val actualRecover = cleric.pray(2)

 // 확인
 assertTrue(actualRecover in 2..4)
 assertTrue(cleric.mp in 7..9)

 }
}
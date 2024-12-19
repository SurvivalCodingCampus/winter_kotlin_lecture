package day3

import org.example.day3.Hero
import org.junit.Assert.*
import kotlin.test.expect

class HeroTest {

@org.junit.Before
 fun setUp() {
  // 테스트 실행 전에 수행되는 부분
 }

@org.junit.After
 fun tearDown() {
 // 테스트 실행 후에 수행되는 부분
 }

@org.junit.Test
fun sleep() {
 // 준비
 var hero = Hero(name = "홍길동", hp = 10)

 // 실행
 hero.sleep()

 // 확인
 assertEquals(100, hero.hp)
 }

@org.junit.Test
  fun run() {}
}


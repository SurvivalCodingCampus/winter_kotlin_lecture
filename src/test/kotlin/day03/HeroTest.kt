package day03

import org.example.day03.Hero
import org.junit.Assert.*

class HeroTest {
    @org.junit.Before
    fun setUp() {
        // 테스트 실행 전에 실행 되는 코드
    }

    @org.junit.After
    fun tearDown() {
        // 테스트 실행 후에 실행 되는 코드
    }

    @org.junit.Test
    fun sleep() {
        // 준비
        val hero = Hero("홍길동", 10)

        // 실행
        hero.sleep()

        // 검증(확인)
        // assertEquals(200, hero.hp) Error
        assertEquals(100, hero.hp)
    }

}
package day03

import org.junit.Assert.*
import kotlin.test.assertEquals

class HeroTest {

    @org.junit.Before
    fun setUp() {
        //테스트 실행 전
    }

    @org.junit.After
    fun tearDown() {
        //테스트 실행 후
    }

    @org.junit.Test
    fun sleep() {
        //준비
        val hero = Hero("홍길동", 10)
        //실행
        hero.sleep()
        assertEquals(100, hero.hp)
    }

    @org.junit.Test
    fun run() {
    }
}
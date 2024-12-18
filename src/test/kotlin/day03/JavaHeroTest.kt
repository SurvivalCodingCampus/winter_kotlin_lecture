package day03

import com.survivalcoding.day03.Hero
import kotlin.test.assertEquals


class JavaHeroTest {

    @org.junit.Before
    fun setUp() {
        // 테스트 실행 전에 수행되는 부분
    }

    @org.junit.After
    fun tearDown() {
        // 테스트 수행 후에 수행되는 부분
    }

    @org.junit.Test
    fun sleep() {
        // 준비
        val hero = Hero("홍길동", 10)

        // 실행
        hero.sleep()

        // 확인
        assertEquals(100, hero.hp)
    }

}
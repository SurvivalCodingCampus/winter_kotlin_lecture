package day03

import org.junit.Assert.*

class HeroTest {

    @org.junit.Test
    fun sleep() {
        // 준비
        val hero = OldHero(name = "홍길동", hp = 10)

        // 실행
        //hero.sleep()

        // 확인
        assertEquals(100, hero.hp)
    }
}
package day06

import org.junit.Test

import org.junit.Assert.*

class PoisonSlimeTest {


    // 포이즌 슬라임의 독 공격
    @Test
    fun `poison Slime poisonAttack Test`() {
        // 준비
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("용사")

        // 실행
        poisonSlime.attack(hero)        // 용사의 hp는 50이기 때문에 10(일반 슬라임 공격) + (독데미지 10)의 데미지를 줄것이다. 50 - 10 = 40

        // 검증
        assertEquals(30, hero.hp)
    }

    // 포이즌 슬라임 poisonCount 테스트
    @Test
    fun `poison Slime poisonCount Test`() {
        // 준비
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("용사")

        // 실행
        repeat(5) {
            poisonSlime.attack(hero)
        }

        assertEquals(0, poisonSlime.positionCount)          // positionCount가 0이 되었는지 확인

    }

}
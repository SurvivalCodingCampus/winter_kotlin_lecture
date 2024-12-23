package day3

import org.junit.Assert.assertEquals
import org.junit.Test

class SlimeTest {


    @Test
    fun `test Slime base damage`() {
        val hero = Hero("hero", 200)
        val slime = Slime("A")
        slime.target = hero
        val before = hero.hp.value

        slime.attack()
        assertEquals(before - Slime.DEFAULT_BASIC_DAMAGE, hero.hp.value)
    }
}
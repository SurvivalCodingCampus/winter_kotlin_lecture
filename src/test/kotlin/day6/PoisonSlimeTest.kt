package day6

import day3.Hero
import day3.Slime
import org.junit.Assert.assertEquals
import org.junit.Test

class PoisonSlimeTest {

    @Test
    fun `poison attack triggers`() {
        val hero = Hero("hero", 200)
        val poisonSlime = PoisonSlime("A")
        poisonSlime.attack()
        assertEquals(PoisonSlime.DEFAULT_POISON_CHARGE, poisonSlime.poisonCharges)

        poisonSlime.target = hero
        var before = hero.hp.value
        hero.hp.percent -= PoisonSlime.DEFAULT_POISON_DAMAGE_PERCENT
        val expectedTotalDamage = before - hero.hp.value + Slime.DEFAULT_BASIC_DAMAGE

        hero.hp set before
        poisonSlime.attack()

        assertEquals(PoisonSlime.DEFAULT_POISON_CHARGE - 1, poisonSlime.poisonCharges)
        assertEquals(before - expectedTotalDamage, hero.hp.value)

        before = hero.hp.value
        poisonSlime.poisonCharges = 0
        poisonSlime.attack()
        assertEquals(before - Slime.DEFAULT_BASIC_DAMAGE, hero.hp.value)
    }
}
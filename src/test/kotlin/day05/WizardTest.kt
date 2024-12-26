package day05

import org.junit.Assert.assertEquals
import org.junit.Assert

import org.junit.Test

class WizardTest {

    //TODO junit4에서 assertThrows 하는 방법
    @Test
    fun checkName() {
        Assert.assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "지팡이", power = 80.0)
            Wizard(name = "간", hp = 90, mp = 30, wand = wand)
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkInitialNameValid() {
        val wand = Wand(name = "지팡이", power = 80.0)
        Wizard(name = "간", hp = 90, mp = 30, wand = wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkMpValid() {
        val wand = Wand(name = "지팡이", power = 80.0)
        Wizard(name = "간달프", hp = 90, mp = -5, wand = wand)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkWandPowerRange() {
        Wand(name = "지팡이", power = 200.0)
    }

    @Test
    fun checkWandPowerValid() {
        val wand = Wand(name = "지팡이", power = 50.0)
        assertEquals(50.0, wand.power, 0.0)
    }

    @Test
    fun checkHp() {
        val wand = Wand(name = "지팡이", power = 80.0)
        val wizard = Wizard(name = "간달프", hp = -10, mp = 30, wand = wand)
        assertEquals(0, wizard.hp)
    }

}
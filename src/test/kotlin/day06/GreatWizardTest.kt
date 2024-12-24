package day06

import day03.Hero
import day05.Wand
import org.junit.Test

import org.junit.Assert.*

class GreatWizardTest {

    @Test
    fun checkSuperHeal() {
        //todo 코드구현
        val wand = Wand("지팡이", 80.0)
        val greatWizard = GreatWizard("대마법사", 90, wand = wand)
        val hero = Hero("다덤벼", hp = 33)

     greatWizard.superHeal(hero)


    }
}
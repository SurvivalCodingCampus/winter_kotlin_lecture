//package day06
//
//import org.example.day03.Hero
//import org.example.day05.Wand
//import org.junit.Test
//
//import org.junit.Assert.*
//
//class GreatWizardTest {
//
//    @Test
//    fun `superHeal test`() {
//        val greatWizard = GreatWizard("great wizard", 10, 100, 10, Wand("common wand", 5.0))
//        val hero = Hero("common hero", 10, null)
//
//        greatWizard.superHeal(hero)
//
//        assertEquals(50, greatWizard.mp)
//        assertEquals(Hero.MAX_HP, hero.hp)
//    }
//
//    @Test
//    fun `out of mp for superheal`() {
//        val greatWizard = GreatWizard("great wizard", 10, 10, 10, Wand("common wand", 5.0))
//        val hero = Hero("common hero", 10, null)
//
//        greatWizard.superHeal(hero)
//
//        assertEquals(10, greatWizard.mp)
//        assertEquals(10, hero.hp)
//    }
//}
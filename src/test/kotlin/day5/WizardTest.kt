package day5

import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test

class WizardTest {

    @Test
    fun `initialization safety checks`() {
        val testWizard = Wizard("abc", wand = null)
        assertNull(testWizard.wand)

        assertThrows("name should be longer than 3", IllegalArgumentException::class.java) { Wizard("a") }
        assertThrows("MP cannot be negative value", IllegalArgumentException::class.java) { Wizard("abc", MP = -1.0) }
    }

    @Test
    fun `setter safety checks`() {
        val testWizard = Wizard("abc", wand = null)

        assertThrows("name should be longer than 3", IllegalArgumentException::class.java) { testWizard.name = "a" }
        assertThrows("MP cannot be negative value", IllegalArgumentException::class.java) { testWizard.MP = -1.0 }
        assertThrows("Cannot assign null to wand", IllegalArgumentException::class.java) {
            testWizard.wand = null
        }
    }
}

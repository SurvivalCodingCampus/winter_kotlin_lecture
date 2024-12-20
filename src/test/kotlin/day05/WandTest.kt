package day05

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

import org.example.day05.Wand

class WandTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `wandConstructorNameIsNull`() {
        try {
            val wandAfterNameNull = Wand(null, 5.0)
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }
    }

    @Test
    fun `wandConstructorNameIsTooShort`() {
        try {
            val wandAfterNameNull = Wand("?", 5.0)
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }
    }
    @Test
    fun `wandConstructorPowerIsNegative`() {
        try {
            val wandAfterNameNull = Wand("common wand", -5.0)
        } catch(e: IllegalArgumentException) {
            println("power is negative")
        }
    }

    @Test
    fun `wandConstructorPowerIsTooStrong`() {
        try {
            val wandAfterNameNull = Wand("common wand", 300.0)
        } catch(e: IllegalArgumentException) {
            println("power is too strong")
        }
    }

    @Test
    fun `wandAfterNameIsNull`() {
        val wandAfterNameNull = Wand("common wand", 5.0)
        try {
            wandAfterNameNull.name = null
        } catch(e: IllegalArgumentException) {
            println("name is null")
        }
    }

    @Test
    fun `wandAfterNameIsTooShort`() {
        val wandAfterNameIsTooShort = Wand("common wand", 5.0)
        try {
            wandAfterNameIsTooShort.name = "?"
        } catch(e: IllegalArgumentException) {
            println("name is too short")
        }
    }

    @Test
    fun `wandAfterPowerIsNegative`() {
        val wandAfterPowerIsNegative = Wand("common wand", 5.0)
        try {
            wandAfterPowerIsNegative.power = -5.0
        } catch(e: IllegalArgumentException) {
            println("power is negative")
        }
    }

    @Test
    fun `wandAfterPowerIsTooStrong`() {
        val wandAfterPowerIsTooStrong = Wand("common wand", 5.0)
        try {
            wandAfterPowerIsTooStrong.power = 300.0
        } catch(e: IllegalArgumentException) {
            println("power is too strong")
        }
    }
}
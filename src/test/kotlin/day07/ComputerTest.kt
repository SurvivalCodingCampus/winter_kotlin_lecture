package day07

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

class ComputerTest {

    @Test
    fun setWeight() {
        var computer = Computer("common name", 1000, "white", "super good", 5.0)

        assertThrows<IllegalArgumentException>("weight에 음수를 넣으셨군요.") {
            computer.weight = -5.0
        }
    }
}
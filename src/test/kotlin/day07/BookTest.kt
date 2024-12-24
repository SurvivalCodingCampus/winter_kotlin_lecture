package day07

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

class BookTest {

    @Test
    fun setWeight() {
        var book = Book("common book", 1000, "white", "000-111")

        assertThrows<IllegalArgumentException>("weight에 음수를 넣으셨군요.") {
            book.weight = -5.0
        }
    }
}
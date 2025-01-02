package day10

import org.example.day10.KeyPad
import org.example.day10.StrongBox
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.time.LocalDateTime.*


class StrongBoxTest {

    @Test
    fun `Strong Box Test`(): Unit = assertAll(
        "PadLock/Button/Dial/Finger Counter Test",
        {
            val strongBox = StrongBox(KeyPad.PAD_LOCK)

            repeat(1024 - 1) {
                assertEquals(true, strongBox.get() == null)
            }

            assertEquals(true, strongBox.get() == KeyPad.PAD_LOCK)
        },
        {
            val strongBox = StrongBox(KeyPad.DIAL)

            repeat(30000 - 1) {
                assertEquals(true, strongBox.get() == null)
            }

            assertEquals(true, strongBox.get() == KeyPad.DIAL)

        },
        {
            val strongBox = StrongBox(KeyPad.FINGER)

            repeat(1000000 - 1) {
                assertEquals(true, strongBox.get() == null)
            }

            assertEquals(true, strongBox.get() == KeyPad.FINGER)

        },
        {
            val strongBox = StrongBox(KeyPad.BUTTON)

            repeat(10000 - 1) {
                assertEquals(true, strongBox.get() == null)
            }

            assertEquals(true, strongBox.get() == KeyPad.BUTTON)

        },
    )
}


package day10

import org.example.day07.Asset
import org.example.day07.Computer
import org.example.day09.Book
import org.example.day10.KeyType
import org.example.day10.StrongBox
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow

class StrongBoxTest {

    @Before
    fun setUp() {
    }

    @Test
    fun `다양한 타입 생성 테스트`() {
        assertDoesNotThrow {
            val sb1 = StrongBox<Book>(KeyType.DIAL)
            val sb2 = StrongBox<Asset>(KeyType.BUTTON)
            val sb3 = StrongBox<Computer>(KeyType.FINGER)
        }
    }

    @Test
    fun `put() test`() {
        val item = Book("소중한 책", "소중한")
        val bookStrongBox = StrongBox<Book>(KeyType.PADLOCK)
        bookStrongBox.put(item)
        repeat(KeyType.PADLOCK.unlockCnt - 1) {
            bookStrongBox.get()
        }

        assertEquals(item, bookStrongBox.get())
    }

    @Test
    fun `get() test`() = assertAll(
        "금고가 비었을 때, 모든 keyType 확인, 금고에서 아이템을 꺼낸 후 다시 꺼낼 때",
        {
            val bookStrongBox = StrongBox<Book>(KeyType.DIAL)
            assertThrows(IllegalArgumentException::class.java) {
                bookStrongBox.get()
            }
        },
        {
            KeyType.entries.forEach { keyType ->
                val bookStrongBox = StrongBox<Book>(keyType)
                val book = Book("소중한 책", "소중한")
                bookStrongBox.put(book)
                repeat(keyType.unlockCnt - 1) { time ->
                    val item = bookStrongBox.get()
                    if (time % 100 == 0) {
                        assertNull(item)
                    }
                }
                assertEquals(book, bookStrongBox.get())
            }
        },
        {
            val bookStrongBox = StrongBox<Book>(KeyType.PADLOCK)
            val book = Book("소중한 책", "소중한")
            bookStrongBox.put(book)
            repeat(KeyType.PADLOCK.unlockCnt) {
                bookStrongBox.get()
            }
            assertThrows(IllegalArgumentException::class.java) {
                bookStrongBox.get()
            }
        }
    )
}
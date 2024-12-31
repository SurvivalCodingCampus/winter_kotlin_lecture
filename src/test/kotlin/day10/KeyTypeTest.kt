package day10

import day05.Wand
import day07.Computer
import day09.Book
import org.junit.Test
import org.junit.Assert.*
import java.time.LocalDateTime

class KeyTypeTest {

    @Test
    fun getPadlockItem() {
     val something = StrongBox<String>(KeyType.PADLOCK)
     something.put("스초생 케이크")
     for (i in 1..1024) {
      assertEquals(null, something.get())
     }
      assertEquals("스초생 케이크", something.get())
    }

    @Test
    fun getButtonItem() {
        val book = day09.Book("생존코딩", "오준석님", LocalDateTime.now())
        val something = StrongBox<Book>(KeyType.BUTTON)
        something.put(book)
        for (i in 1..10000) {
            assertEquals(null, something.get())
        }
        assertEquals(book, something.get())
    }

    @Test
    fun getDialItem() {
        val lenovo = Computer("레노바", 30, "gray", 1.5, "메이커")
        val something = StrongBox<Computer>(KeyType.DIAL)
        something.put(lenovo)
        for (i in 1..30000) {
            assertEquals(null, something.get())
        }
        assertEquals(lenovo, something.get())
    }

    @Test
    fun getFingerItem() {
        val wand = Wand("지팡팡", 100.0)
        val something = StrongBox<Wand>(KeyType.FINGER)
        something.put(wand)
        for (i in 1..1000000) {
            assertEquals(null, something.get())
        }
        assertEquals(wand, something.get())
    }
}
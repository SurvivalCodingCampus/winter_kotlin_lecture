package day09

import org.example.day09.Book
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

class BookTest {
    @Before
    fun setUp() {

    }

    @Test
    fun `equals() 테스트`() {
        val dateTime = LocalDateTime.of(2020, 1, 4, 0, 0, 0)
        val bookA = Book("A의 모험", "A", dateTime)
        val bookB = Book("A의 모험", "카피왕", dateTime)

        assertTrue(bookA == bookB)
    }

    @Test
    fun `sorted() 정렬 테스트`() {
        val books = listOf(
            Book(
                title = "4",
                author = "김정렬",
                LocalDateTime.of(2014, 1, 20, 0, 0, 0)
            ),
            Book(
                title = "2",
                author = "김정렬",
                LocalDateTime.of(2010, 6, 4, 0, 0, 0)
            ),
            Book(
                title = "1",
                author = "김정렬",
                LocalDateTime.of(2010, 1, 4, 0, 0, 0)
            ),
            Book(
                title = "5",
                author = "김정렬",
                LocalDateTime.of(2020, 8, 4, 0, 0, 0)
            ),
            Book(
                title = "3",
                author = "김정렬",
                LocalDateTime.of(2014, 1, 4, 0, 0, 0)
            ),
        )

        val expect = "54321"
        var result = ""
        books.sorted().forEach { result += it.title }
        assertEquals(expect, result)
    }

    @Test
    fun `deepCopy() 테스트`() {
        val bookA = Book("복사하는법", "김복사")
        val copyOfBookA = bookA.deepCopy()
        assertEquals(bookA, copyOfBookA)
        assertNotSame(bookA, copyOfBookA)
    }
}
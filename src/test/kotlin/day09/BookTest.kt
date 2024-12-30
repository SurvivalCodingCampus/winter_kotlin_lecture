package day09

import org.hyunjung.day09.Book
import org.hyunjung.day09.deepCopy
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class BookTest {

    @Test
    fun `제목과 출간일이 같으면 같은 책으로 판단`() {
        val book1 = Book("Sample Title", "Author A", LocalDateTime.of(2024, 1, 1, 10, 0))
        val book2 = Book("Sample Title", "Author B", LocalDateTime.of(2024, 1, 1, 21, 0))

        assertEquals(book1, book2)
    }

    @Test
    fun `제목이 다른 경우 다른 책으로 판단`() {
        val book1 = Book("Sample Title", "Author A", LocalDateTime.of(2024, 1, 1, 10, 0))
        val book2 = Book("Another Title", "Author B", LocalDateTime.of(2024, 1, 1, 15, 0))

        assertNotEquals(book1, book2)
    }

    @Test
    fun `출간일 신상 순으로 정렬`() {
        val book1 = Book("Book 1", "Author A", LocalDateTime.of(2023, 12, 1, 10, 0))
        val book2 = Book("Book 2", "Author B", LocalDateTime.of(2024, 1, 1, 10, 0))
        val book3 = Book("Book 3", "Author C", LocalDateTime.of(2022, 5, 1, 10, 0))

        val books = listOf(book1, book2, book3)
        val sortedBooks = books.sorted()

        assertEquals(listOf(book2, book1, book3), sortedBooks)
    }

    @Test
    fun `Deep Copy 제공`() {
        val originalBook = Book("Original Title", "Author A", LocalDateTime.of(2024, 1, 1, 10, 0))
        val copiedBook = originalBook.copy()

        assertNotSame(originalBook, copiedBook)
        assertEquals(originalBook, copiedBook)
    }

    @Test
    fun `LocalDateTime을 Deep Copy한 결과 동일한 날짜를 가진 LocalDateTime 리턴`() {
        val date = LocalDateTime.of(2024, 1, 1, 10, 0).toLocalDate()
        val copiedDateTime = date.deepCopy()

        assertEquals(date, copiedDateTime.toLocalDate())
    }
}
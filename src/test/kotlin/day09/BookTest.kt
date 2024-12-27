package day09

import org.example.day09.Book
import org.junit.Test

import org.junit.Assert.*

class BookTest {

    @Test
    fun `제목과 출간일(2024-01-01 포맷)이 같으면 같은 Book 으로 판단한다`() {
        val bookA = Book(title = "제목1", author = "A")
        val bookB = Book(title = "제목1", author = "B")

        assertEquals(bookA, bookB)

        val bookC = Book(title = "제목C", author = "C")
        val bookD = Book(title = "제목D", author = "D")

        assertNotEquals(bookC, bookD)

    }

    @Test
    fun `Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함 `() {
        val books = listOf(
            Book(title = "titleA", author = "A"),
            Book(title = "titleB", author = "B"),
            Book(title = "titleC", author = "C"),
            Book(title = "titleD", author = "D")
        )

        val sortedBooks = books.sortedBy { it.publishedDate }
        sortedBooks.forEach { println(it.publishedDate) }
    }

}
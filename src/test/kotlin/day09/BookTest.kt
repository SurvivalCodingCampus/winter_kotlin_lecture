package day09

import org.example.day09.Book
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BookTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `책은 제목과 출간일이 같으면 같은 책이다`() {
        val book1 = Book("나루토", "오다", LocalDateTime.of(1999, 9, 9, 19, 50, 35))
        val book2 = Book("나루토", "토가시", LocalDateTime.of(1999, 9, 9, 12, 25, 15))
        val book3 = Book("원피스", "오다", LocalDateTime.of(1999, 9, 9, 12, 25, 15))

        assertEquals(true, book1 == book2)
        assertEquals(false, book1 == book3)
    }

    @Test
    fun `책은 신간을 기준으로 정렬한다`() {
        val book1 = Book("나루토", "마사시", LocalDateTime.of(2006, 9, 9, 19, 50, 35))
        val book2 = Book("원펀맨", "ONE", LocalDateTime.of(2015, 9, 9, 12, 25, 15))
        val book3 = Book("헌터헌터", "토가시", LocalDateTime.of(1997, 9, 9, 19, 50, 35))
        val book4 = Book("베르세르크", "미우라", LocalDateTime.of(1989, 9, 9, 12, 25, 15))
        val book5 = Book("원피스", "오다", LocalDateTime.of(2024, 6, 12, 5, 7, 31))
        val book6 = Book("블리치", "쿠보", LocalDateTime.of(2000, 12, 24, 8, 9, 58))

        var books: List<Book> = mutableListOf(book1,book2,book3,book4, book5, book6)
//        books.sort()

        assertEquals("1989-09-09", books.sorted()[5].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("1997-09-09", books.sorted()[4].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("2000-12-24", books.sorted()[3].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("2006-09-09", books.sorted()[2].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("2015-09-09", books.sorted()[1].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("2024-06-12", books.sorted()[0].publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
    }

    @Test
    fun `깊은 복사 테스트`() {
        val bookOrigin = Book("원본책", "원본작가", LocalDateTime.of(1999, 9, 9, 12, 15, 52))
        val bookCopy: Book = bookOrigin.deepCopy()

        // 인스턴스 깊은 복사
        assertEquals(false, bookOrigin.publishedDate === bookCopy.publishedDate)
        assertEquals("원본책", bookOrigin.title)
        assertEquals("원본책", bookCopy.title)
        assertEquals("원본작가", bookOrigin.author)
        assertEquals("원본작가", bookCopy.author)
        assertEquals("1999-09-09", bookOrigin.publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        assertEquals("1999-09-09", bookCopy.publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
    }
}
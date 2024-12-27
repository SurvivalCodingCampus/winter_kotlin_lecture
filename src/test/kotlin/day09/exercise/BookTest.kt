package day09.exercise

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class BookTest {

    @Test
    fun `제목과 출간일이(2024-01-01)이 같으면 같은 책으로 판단`() {
        val testDate = LocalDateTime.of(2024, 12, 25, 0, 0, 0, 0)
        val testDate2 = LocalDateTime.of(2024, 12, 24, 0, 0, 0, 0)
        val book = Book("우리들의 일그러진 영웅", "이문열", testDate)
        val book2 = Book("우리들의 일그러진 영웅", "이문열", testDate)

        val book3 = Book("우리들의 일그러진 영웅", "이문열", testDate)
        val book4 = Book("우리들의 일그러진 영웅", "이문열", testDate2)

        assertEquals(book, book2)           // 타이틀과 출간일이 모두 같은 경우
        assertNotEquals(book3, book4)       // 출간일이 다른 경우
    }

    @Test
    fun `Book 인스턴스를 담고 있는 컬렉션에 대해 sorted()를 수행하면 `() {
        val testDate = LocalDateTime.of(2024, 12, 23, 0, 0, 0, 0)
        val testDate2 = LocalDateTime.of(2024, 12, 24, 0, 0, 0, 0)
        val testDate3 = LocalDateTime.of(2024, 12, 25, 0, 0, 0, 0)
        val book = Book(title = "이솝우화", "미상", publishedDate = testDate)
        val book2 = Book(title = "이솝우화", "미상", publishedDate = testDate2)
        val book3 = Book(title = "이솝우화", "미상", publishedDate = testDate3)

        val bookList = mutableListOf<Book>(book2, book3, book)
        val testBookList = mutableListOf<Book>(book, book2, book3)
        val sortedBookList = bookList.sorted()
        assertArrayEquals(sortedBookList.toTypedArray(), testBookList.toTypedArray())
    }

    @Test
    fun `깊은 복사 테스트`() {
        val book = Book("이솝우화", "author")
        val copyBook = book.deepCopy()

        assertEquals(book, copyBook)        // 객체의 값 비교
        assertNotSame(book, copyBook)       // 참조 비교
    }
}
package day09.exercise

import org.junit.Test

import org.junit.Assert.*
import utils.CommonUtils.simpleFormatter
import java.time.LocalDateTime

class BookTest {

    @Test
    fun `제목과 출간일이(2024-01-01)이 같으면 같은 책으로 판단`() {
        val testDate = LocalDateTime.of(2024, 12, 25, 10, 0, 0, 0)
        val testDate2 = LocalDateTime.of(2024, 12, 25, 8, 0, 0, 0)
        val testDate3 = LocalDateTime.of(2024, 12, 24, 10, 0, 0, 0)
        val book = Book("우리들의 일그러진 영웅", "이문열", testDate)
        val book2 = Book("우리들의 일그러진 영웅", "이문열", testDate2)
        val book3 = Book("우리들의 일그러진 영웅", "이문열", testDate3)


        // 타이틀과 출간일이 모두 같은 경우
        assertEquals(book, book2)

        // 타이틀은 같지만 출간일이 다른 경우
        assertNotEquals(book, book3)
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

        // 원본
        val book = Book("이솝우화", "author", LocalDateTime.of(2025, 1, 1, 10, 0, 0))

        // 복사 진행
        val copyBook = book.deepCopy()

        // 객체 값 비교
        assertEquals(book, copyBook)

        // 참조 비교: 객체와 내부 레퍼런스 타입 참조 비교
        assertNotSame(book, copyBook)


        // 내부 레퍼런스 값 비교 년월일까지
        assertEquals(book.publishedDate.toLocalDate(), copyBook.publishedDate.toLocalDate())
    }
}
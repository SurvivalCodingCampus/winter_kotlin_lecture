package day09

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class BookTest {

    @Test
    fun checkTitleAndPublishedDateEquals() {
     val bookA = Book("Book1", "Author1", LocalDateTime.of(2024, 1, 1, 7, 30))
     val bookB = Book("Book1", "Author1", LocalDateTime.of(2024, 1, 1, 4, 0))
        assertTrue(bookA == bookB)
        assertTrue(bookA.hashCode() == bookB.hashCode())
    }

    @Test
    fun checkCompareTo() {
     val book1 = Book("Book1", "Author1", LocalDateTime.of(2023, 1, 1, 0, 0))
     val book2 = Book("Book2", "Author2", LocalDateTime.of(2024, 1, 1, 0, 0))
        assertTrue(book2.publishedDate > book1.publishedDate)
        assertTrue(book2.compareTo(book1) < 0)
    }

 @Test
 fun checkSortByPublishedDate() {
  val books = listOf(
   Book("Book1", "Author1", LocalDateTime.of(2023, 1, 1, 0, 0)),
   Book("Book2", "Author2", LocalDateTime.of(2024, 1, 1, 0, 0))
  )
  val sortedBooks = books.sortedByDescending { it.publishedDate }
     assertTrue(sortedBooks[0].title == "Book2")
     assertTrue(sortedBooks[1].title == "Book1")
 }

 @Test
 fun checkDeepCopy() {
  val bookOriginal = Book("Original", "Author", LocalDateTime.of(2022, 1, 1, 0, 0))
  val bookCopy = bookOriginal.deepCopy()
     assertTrue(bookOriginal !== bookCopy) // 다른 참조
     assertTrue(bookOriginal == bookCopy)  // 같은 값, 다른 객체
 }

}
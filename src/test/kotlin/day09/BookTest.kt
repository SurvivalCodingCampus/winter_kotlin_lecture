package day09

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class BookTest {

    @Test
    fun testEquals() {
     // 같은 책인지 판단하는 테스트
     val book1: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 12, 27, 12, 52))
     val book2: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 11, 12, 10, 54))
     val book3: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 12, 27, 13, 52))

     assertTrue(book1 == book3)
     assertFalse(book1 == book2)
    }

    @Test
    fun compareTo() {
     // 정렬이 되는지 확인하는 테스트
     val book1: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 12, 27, 12, 52))
     val book2: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 11, 12, 10, 54))

     var list: List<Book> = listOf(book1, book2)
     // 정렬 전
     assertTrue(book1 === list[0])
     assertTrue(book2 === list[1])

     list = list.sorted()
     // 정렬 후
     assertTrue(book2 === list[0])
     assertTrue(book1 === list[1])
    }

    @Test
    fun copy() {
     val book1: Book = Book("good book", "good author",
      LocalDateTime.of(2024, 12, 27, 12, 52))
     val book2: Book = book1.copy()

     // 깊은 복사가 되었는지 확인
     assertFalse(book1 === book2)
     assertFalse(book1.title === book2.title)
     assertFalse(book1.author === book2.author)
     assertFalse(book1.publishedDate === book2.publishedDate)
    }
}
package day09.exercise

import utils.CommonUtils.simpleFormatter
import java.time.LocalDateTime


/**
 * 다음 동작을 할 수 있도록 Book 클래스 수정
 *
 * 1) 제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다.
 * 2) Book 인스턴스를 담고 있는 컬렉션에 대해 sorted를 수행하면 출간일이 신상 순서대로 정렬되어야 함.
 * 3) deep copy()를 제공
 */

data class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        return this.publishedDate.simpleFormatter().compareTo(other.publishedDate.simpleFormatter())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (publishedDate.simpleFormatter() != other.publishedDate.simpleFormatter()) return false

        return true
    }

    override fun hashCode(): Int {
        return 31 * title.hashCode() + publishedDate.hashCode()
    }

    // 깊은 복사 메소드
    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate
    ): Book = Book(title, author, publishedDate)
}


fun main() {
    val testDate = LocalDateTime.of(2024, 12, 25, 0, 0, 0, 0)
    val testDate2 = LocalDateTime.of(2024, 12, 24, 0, 0, 0, 0)
    val testDate3 = LocalDateTime.of(2024, 12, 23, 0, 0, 0, 0)
    val book = Book(title = "이솝우화", "미상", publishedDate = testDate)
    val book2 = Book(title = "이솝우화", "홍홍", publishedDate = testDate2)

    println(book == book2)
    val book3 = Book(title = "이솝우화", author = "흥흥", publishedDate = testDate3)
    val bookList = mutableListOf<Book>()
    bookList.add(book)
    bookList.add(book2)
    bookList.add(book3)
    val sortedList = bookList.sorted()
    println(sortedList)

    val firstBook = Book("이솝우화", "author")
    val copyFirstBook = firstBook.deepCopy("ㄹㅇㄴㄹ", "ㄹㅇㄴㄹㄴㄹ", testDate)
    println(firstBook == copyFirstBook)
    println(firstBook === copyFirstBook)
}
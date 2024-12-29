package org.example.day09

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
) {

    fun convertDateToString(publishedDate: LocalDateTime): String {
        return publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (convertDateToString(publishedDate) != convertDateToString(other.publishedDate)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

    fun deepCopy(): Book {
        val copyTitle: String = title
        val copyAuthor: String = author
        val copyPublishedDate: LocalDateTime =  LocalDateTime.of(publishedDate.year, publishedDate.month, publishedDate.dayOfMonth, publishedDate.hour, publishedDate.minute)
        val copyBook = Book(copyTitle, copyAuthor, copyPublishedDate)
        return copyBook
    }

}

fun main() {


    val book1 = Book(title = "title", author = "A")
    val copyBook1 = book1.deepCopy()

    val books = listOf(
        Book(title = "title", author = "A"),
        Book(title = "title", author = "B"),
        Book(title = "title", author = "C"),
        Book(title = "title", author = "D")
    )

    // 책들을 발행일 기준으로 정렬
    val sortedBooks = books.sortedBy { it.publishedDate }
    sortedBooks.forEach { println(it.publishedDate) }


    println(book1.publishedDate.hashCode())
    println(copyBook1.publishedDate.hashCode())

    println(book1 === copyBook1)
    println(book1 == copyBook1)
}
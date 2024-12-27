package org.hyunjung.day09

import java.time.LocalDate
import java.time.LocalDateTime

fun LocalDate.deepCopy(): LocalDateTime {
    return this.atStartOfDay()
}

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {

    // 제목과 출간일이 같으면 같은 책으로 판단
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false
        return title == other.title && publishedDate.toLocalDate() == other.publishedDate.toLocalDate()
    }

    override fun hashCode(): Int {
        return title.hashCode() * 31 + publishedDate.toLocalDate().hashCode()
    }

    // 출간일 기준으로 신상 순서대로 정렬
    override fun compareTo(other: Book): Int {
        return this.publishedDate.toLocalDate().compareTo(other.publishedDate.toLocalDate())
    }

    // Deep Copy
    fun copy(): Book {
        return Book(title, author, publishedDate.toLocalDate().deepCopy())
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', publishedDate=$publishedDate)"
    }
}

fun main() {
    val originalBook = Book("Kotlin in Action", "Dmitry Jemerov", LocalDateTime.of(2023, 12, 1, 10, 30))
    val copiedBook = originalBook.copy()

    println("Original: $originalBook")
    println("Copied: $copiedBook")
    println("Are they the same instance? ${originalBook === copiedBook}") // false
    println("Are they equal? ${originalBook == copiedBook}") // true
}
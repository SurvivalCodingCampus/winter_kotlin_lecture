package org.example.day09

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    private val formattedPublishedDate =
        publishedDate.format(DateTimeFormatter.ISO_DATE)

    override fun compareTo(other: Book): Int {
        return -formattedPublishedDate.compareTo(other.formattedPublishedDate)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (formattedPublishedDate != other.formattedPublishedDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + formattedPublishedDate.hashCode()
        return result
    }

    fun deepCopy(
        title: String = this.title,
        author: String = this.author,
        publishedDate: LocalDateTime = this.publishedDate
    ): Book {
        val newLocalDateTime = LocalDateTime.of(publishedDate.toLocalDate(), publishedDate.toLocalTime())
        return Book(title, author, newLocalDateTime)
    }
}
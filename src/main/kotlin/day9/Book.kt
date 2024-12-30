package day9

import kotlinx.datetime.*

data class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        return -publishedDate.date.compareTo(other.publishedDate.date)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book
        if (title != other.title) return false
        if (publishedDate.date != other.publishedDate.date) return false
        return true
    }

    fun deepCopy(): Book {
        return this.copy(
            publishedDate = publishedDate.toInstant(TimeZone.UTC)
                .toLocalDateTime(TimeZone.UTC)
        )
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result += 31 * publishedDate.date.hashCode()
        return result
    }
}
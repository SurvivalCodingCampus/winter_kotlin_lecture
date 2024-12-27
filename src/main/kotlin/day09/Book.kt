package org.example.day09

import com.sun.jdi.IntegerType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
): Comparable<Book> {
    var publishedDateString: String = publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    var compareDate = publishedDateString.replace("-", "").toInt()

    override fun compareTo(other: Book): Int {
        return -compareDate.compareTo(other.compareDate)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
//        if (author != other.author) return false
        if (publishedDateString != other.publishedDateString) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }

    override fun toString(): String {
        return "제목:'$title', 작가:'$author', 출간일:'$publishedDateString'"
    }

    fun deepCopy(): Book {
        val dateList = publishedDateString.split("-")
        val year = Integer.parseInt(dateList[0])
        val month = Integer.parseInt(dateList[1])
        val day = Integer.parseInt(dateList[2])

        return Book(title, author, LocalDateTime.of(year,month,day,0,0,0))
    }
}

fun main() {
    val book1 = Book("나루토", "오다1", LocalDateTime.of(1999, 9, 9,0,0,0))
    val book11 = Book("나루토", "오다11", LocalDateTime.of(1999, 9, 9,0,0,0))
    val book2 = Book("원피스", "오다2", LocalDateTime.of(2024, 6, 12,0,0,0))
    val book3 = Book("블리치", "오다3", LocalDateTime.of(2000, 12, 24,0,0,0))

    val books = listOf(book1, book2, book3)

    println("같은 책인지 확인 : ${book1 == book11}")

//    println(books.sortedByDescending { it.publishedDateString })

    // sorted() 사용하려고 내부에 compareTo() 재정의 함
    println("정렬전 ${books}")
    println("정렬후 ${books.sorted()}")

    // deep copy
    val bookOrigin = Book("원본책", "원본작가",LocalDateTime.of(1999, 9, 9,0,0,0))
    val bookCopy: Book = bookOrigin.deepCopy()

    println("깊은 복사인가 (인스턴스인 출간일로 확인) : ${bookOrigin.publishedDate === bookCopy.publishedDate}")

    println("원본 : ${bookOrigin.title} ${bookOrigin.author} ${bookOrigin.publishedDate}")
    println("복사 : ${bookCopy.title} ${bookCopy.author} ${bookCopy.publishedDate}")
}
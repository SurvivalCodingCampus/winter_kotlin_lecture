package org.example.day09

import java.time.LocalDateTime


//제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다
//Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함
//deep copy 를 제공한다


class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {
    private var _publishedData: String = publishedDate.toString().slice(0..9)

    override fun compareTo(other: Book): Int {
        return -publishedDate.compareTo(other.publishedDate)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        val otherPublishedDate = other.publishedDate.toString().slice(0..9)

        if (title != other.title) return false
        if (_publishedData != otherPublishedDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.hashCode()
        return result
    }


    fun copy(
        title: String = this.title,
        author: String = this.author,
    ): Book {
        val deepCopyValue: LocalDateTime = publishedDate

        return Book(title, author, deepCopyValue)
    }
}


fun main() {
//    val obj = Hero(name = "haha")

    val collectionData = Book("hello", "you", LocalDateTime.of(2034, 8, 23, 3, 1))
    val collectionData3 = Book("hello", "you323", LocalDateTime.of(1987, 8, 23, 14, 1))


    val value = Book("hello", "you", LocalDateTime.of(2034, 8, 23, 3, 1))
    val deepcopy = value.copy()

    println("$value $deepcopy")
    println("compare : ${value == deepcopy} / reference is : ${value === deepcopy}")
    println("compare published Date : ${value.publishedDate == deepcopy.publishedDate} / ${value.publishedDate}, ${deepcopy.publishedDate}")




}
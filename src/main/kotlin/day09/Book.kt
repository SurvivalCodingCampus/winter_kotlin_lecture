package day09

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now(),
): Comparable<Book> {
    override fun equals(other: Any?): Boolean {
        other as Book
        return if(title.equals(other.title) &&
            publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")).
            equals(other.publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")))) true else false
    }

    override fun compareTo(other: Book): Int {
        return (publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")).toString().
        compareTo(other.publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")).toString()))
    }

    override fun toString(): String {
        return "title: $title\n author: $author\n publishedDate: ${publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))}"
    }

    fun copy(): Book {
        val newTitle: String = title.toCharArray().toString()
        val newAuthor: String = author.toCharArray().toString()
        val newPublishedDate: LocalDateTime = LocalDateTime.of(publishedDate.year, publishedDate.month, publishedDate.dayOfMonth, publishedDate.hour, publishedDate.minute)
        val newBook: Book = Book(newTitle, newAuthor, newPublishedDate)
        return newBook
    }

    fun showBookInfo() {
        println("title: $title")
        println("author: $author")
        println("publishedDate: ${publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))}")
    }

}

// 잠시 테스트 한 내용
//fun main() {
//    val book1: Book = Book("good book", "good author", LocalDateTime.of(2024, 12, 27, 12, 52))
//    val book2: Book = Book("good book", "good author", LocalDateTime.of(2024, 11, 12, 10, 54))
//
//    println("title: ${book1.title}")
//    println("author: ${book1.author}")
//    println("publishDate: ${book1.publishedDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))}")
//
//    if(book1 == book2)
//        println("equal")
//    else
//        println("not equal")
//
//    println("-----not sorted------")
//    var list: List<Book> = listOf(book1, book2)
//    for(book in list)
//        book.showBookInfo()
//    list = list.sorted()
//    println("------sorted------")
//    for(book in list)
//        book.showBookInfo()
//    println("-----deep copy------")
//    val book3: Book = book1.copy()
//    if(book3 === book1)
//        println("equal book class")
//    else
//        println("not equal book class")
//
//    if(book3.title === book1.title)
//        println("equal title")
//    else
//        println("not equal title")
//
//    if(book3.author === book1.author)
//        println("equal author")
//    else
//        println("not equal author")
//
//    if(book3.publishedDate === book1.publishedDate)
//        println("equal publishedDated")
//    else
//        println("not equal publishedDated")
//}
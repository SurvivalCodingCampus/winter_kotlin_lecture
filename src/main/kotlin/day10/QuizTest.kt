package day10

data class Person(val name: String, val age: Int) {

}

fun main() {
    val p1 = Person("kim", 20)
    val p2 = Person("kim", 20)
    print(p1 == p2)

    val books = listOf(
        Book("B", 1000),
        Book("A", 2000),
        Book("C", 1500)
    )

    println(books.sorted().first().title)
}

class Book(val title: String, val price: Int) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        return this.price - other.price
    }
}

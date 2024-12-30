package day09
/*
 제목과 출간일(2024-01-01)이 같으면 같은 책으로 판단한다
 Book 인스턴스를 담고 있는 컬렉션에 대해 sorted() 를 수행하면 출간일이 신상 순서대로 정렬되어야 함
 deep copy 를 제공한다
*/

/* < equals, hashCode 오버라이딩 하는 이유 >
 '제목과 출간일이 동일하면 동일한 책으로 간주' 이 조건을 적용하려면 equals를 오버라이딩 해야 한다
 (기본적으로 객체 비교는 참조값을 기준으로 판단한다)

 hashCode를 수정하지 않으면, 동일한 객체로 간주해야 할 두 객체가 다른 해시 코드를 가져 충돌이 발생할 수 있다
 (hashSet은 객체를 저장할 때 해시코드를 사용해 중복을 체크한다)

 '출간일 순서대로 정렬' 이 조건을 적용하려면 compareTo를 정의해야 한다
*/

import java.time.LocalDateTime

data class Book(
    val title: String,
    val author: String,
    val publishedDate: LocalDateTime = LocalDateTime.now()
) : Comparable<Book> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true     // 참조(메모리 주소)가 같으면 동일한 객체
        if (javaClass != other?.javaClass) return false

        other as Book

        if (title != other.title) return false
        if (author != other.author) return false
        if (publishedDate.toLocalDate() != other.publishedDate.toLocalDate()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + publishedDate.toLocalDate().hashCode()
        return result
    }

    override fun compareTo(other: Book): Int {
        println("this: $this, other: $other")
        return other.publishedDate.compareTo(this.publishedDate)
        //this 객체와 other 객체를 비교하여 this가 other보다 크면 양수, 작으면 음수, 같으면 0을 반환
        //other 객체가 먼저 오고, this 객체가 뒤에 오도록 설정하면 내림차순으로 비교 된다
        //this가 book2, other가 book1
        //반환값이 1이지만 내림차순을 위해 반대로 -1 반환
    }

    //    fun deepCopy() = Book(title, author, publishedDate) // 불변객체만 포함될 경우 이렇게 쓸 수 있지만, 클래스가 확장될 경우를 대비해서 깊은 복사를 보장해야 한다
    fun deepCopy() = Book(title = this.title, author = this.author, publishedDate = this.publishedDate)

}

fun main() {
    val book1 = Book("Book1", "Author1", LocalDateTime.of(2023, 1, 1, 0, 0))
    val book2 = Book("Book2", "Author2", LocalDateTime.of(2024, 1, 1, 0, 0))
    val book3 = book2.deepCopy()
    println(book3 === book2) //false
    val books = listOf(book1, book2, book3).sortedByDescending { it.publishedDate }
    println(books)

    println(book2 < book1)    // true. 내림차순이라 book2가 최신이므로 작다고 간주
    println(book2.compareTo(book1))
}

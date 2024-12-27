package day9

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import org.junit.Assert
import org.junit.Test

class BookTest {
    @Test
    fun `collection of Book is sorted by recent release`() {
        val unorderedDates = arrayOf("2024-01-01", "2024-03-03", "2024-02-02").map {
            LocalDateTime(LocalDate.parse(it), LocalTime.fromSecondOfDay(1))
        }
        val shouldBe = unorderedDates.sortedDescending()

        val unorderedBooks = unorderedDates.map {
            Book("A", "John", it)
        }
        val ordered = unorderedBooks.sorted().map { it.publishedDate }
        shouldBe.zip(ordered).forEach {
            Assert.assertEquals(it.first, it.second)
        }
    }

    @Test
    fun `deepCopied Book check`() {
        val test = Book("A", "John")
        val copied = test.deepCopy()
        Assert.assertEquals(test.title, copied.title)
        Assert.assertEquals(test.author, copied.author)
        Assert.assertEquals(test.publishedDate, copied.publishedDate)
        Assert.assertNotSame(test.publishedDate, copied.publishedDate)
    }

}
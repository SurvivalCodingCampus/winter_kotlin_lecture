package day09

import day06.Slime.Companion.SLIME_DAMAGE
import org.example.day03.Cleric
import org.example.day03.GreatWizard
import org.example.day03.GreatWizard.Companion.GREAT_WIZARD_MAX_MP
import org.example.day03.GreatWizard.Companion.USE_SUPER_HEAL_MP
import org.example.day03.MAX_HP
import org.example.day03.Wizard
import org.example.day09.Book
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll
import java.time.LocalDateTime
import java.time.LocalDateTime.*


class BookTest {

    @Test
    fun `Test Book class`(): Unit = assertAll(
        "Deep copy / compare / list sorted() ",
        {
            val ant = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val deepCopy = ant.copy()

            // checking reference address
            assertEquals(false, ant === deepCopy)

            // checking title
            assertEquals(true, ant.title == deepCopy.title)

            // checking author
            assertEquals(true, ant.author == deepCopy.author)

            // checking date
            assertEquals(true, ant.publishedDate == deepCopy.publishedDate)


            println("-------done Test #1------")
        },
        {
            val ant = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val antVol2 = Book("개미", "National Geo Graphic", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val brain = Book("뇌", "National Geo Graphic", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val brainVol2 = Book("뇌", "National Geo Graphic", LocalDateTime.of(2011, 4, 30, 11, 0, 0))

            // checking comparing book (title, publishedDateTime)
            assertEquals(true, ant == antVol2)

            // different title
            assertEquals(false, ant == brain)

            // different LocalDatTime
            assertEquals(false, ant == brainVol2)

            // different, title LocalDatTime
            assertEquals(false, brain == brainVol2)
            println("-------done Test #2------")
        },
        {
            val ant = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val antVol2 = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 4, 11, 0, 0))
            val antVol3 = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 12, 11, 0, 0))

            val antSeries: List<Book> = listOf(ant, antVol2, antVol3)
            val dateOfRelease: List<LocalDateTime> =
                listOf(ant.publishedDate, antVol2.publishedDate, antVol3.publishedDate)

            //checking
            antSeries.forEachIndexed({ index, it ->
                assertEquals(true, it.publishedDate == dateOfRelease[index])
            })

            println("-------done Test #3-----")
        },
        {
            val ant = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 1, 11, 0, 0))
            val antVol2 = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 4, 11, 0, 0))
            val antVol3 = Book("개미", "베르나르베르베르", LocalDateTime.of(2011, 4, 12, 11, 0, 0))

            val antSeries: List<Book> = listOf(ant, antVol2, antVol3)
            val reversedAntSeries: List<Book> = listOf(antVol3, antVol2, ant)

            //checking sorted
            val sortedSeries = antSeries.sorted()

            sortedSeries.forEachIndexed({ index, it ->
                assertEquals(true, it.publishedDate == reversedAntSeries[index].publishedDate)
            })
            println("-------done Test #4-----")
        }

    )
}


package day07

import org.example.day07.Book
import org.example.day07.TangibleAsset
import org.example.day07.Thing
import org.junit.Assert.*
import org.junit.Test

class BookTest {

    @Test
    fun `Book은 TangibleAsset과 Thing을 상속 받는다`() {
        val book = Book("코틀린의 정석", 25000, "초록", 0.5, "978-89-12345-00-1")
        assertTrue(book is TangibleAsset)
        assertTrue(book is Thing)

        val tangibleAssetsMember = TangibleAsset::class.members.map { it.name }
        val thingMember = Thing::class.members.map { it.name }

        val bookMember = book::class.members.map { it.name }

        assertTrue("TangibleAsset의 멤버를 모두 포함해야 한다.", bookMember.containsAll(tangibleAssetsMember))

        assertTrue("Ting의 맴버를 모두 포함해야 한다.", bookMember.containsAll(thingMember))
    }

}
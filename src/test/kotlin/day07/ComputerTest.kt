package day07

import org.example.day07.Computer
import org.example.day07.TangibleAsset
import org.example.day07.Thing
import org.junit.Assert.*
import org.junit.Test

class ComputerTest {
    @Test
    fun `Computer은 TangibleAsset과 Thing을 상속 받는다`() {
        val computer = Computer("맥북프로", 2500000, "은색", 1.5, "Apple")
        assertTrue(computer is TangibleAsset)
        assertTrue(computer is Thing)

        val assetsMember = TangibleAsset::class.members.map { it.name }
        val thingMember = Thing::class.members.map { it.name }

        val computerMember = computer::class.members.map { it.name }

        assertTrue("TangibleAsset의 멤버를 모두 포함해야 한다.", computerMember.containsAll(assetsMember))

        assertTrue("Thing의 맴버를 모두 포함해야 한다.", computerMember.containsAll(thingMember))
    }

}
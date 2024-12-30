package day10

import org.junit.Test

import org.junit.Assert.*

class StrongBoxTest {

    @Test
    fun get() {
        // KeyType is PADLOCK
        var boxPadlock: StrongBox<String> = StrongBox(StrongBox.KeyType.FINGER)
        boxPadlock.put("hello")

        for(i in 1..StrongBox.KeyType.FINGER.count)
            assertEquals(null, boxPadlock.get())
        assertEquals("hello", boxPadlock.get())

        // KeyType is BUTTON
        var boxButton: StrongBox<String> = StrongBox(StrongBox.KeyType.BUTTON)
        boxButton.put("hello")

        for(i in 1..StrongBox.KeyType.BUTTON.count)
            assertEquals(null, boxButton.get())
        assertEquals("hello", boxButton.get())

        // KeyType is DIAL
        var boxDIAL: StrongBox<String> = StrongBox(StrongBox.KeyType.DIAL)
        boxDIAL.put("hello")

        for(i in 1..StrongBox.KeyType.DIAL.count)
            assertEquals(null, boxDIAL.get())
        assertEquals("hello", boxDIAL.get())

        // KeyType is FINGER
        var boxFINGER: StrongBox<String> = StrongBox(StrongBox.KeyType.FINGER)
        boxFINGER.put("hello")


        for(i in 1..StrongBox.KeyType.FINGER.count)
            assertEquals(null, boxFINGER.get())
        assertEquals("hello", boxFINGER.get())
    }
}
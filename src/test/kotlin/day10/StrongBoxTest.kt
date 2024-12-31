package day10

import org.hyunjung.day10.KeyType
import org.hyunjung.day10.StrongBox
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class StrongBoxTest {

    private lateinit var padlockBox: StrongBox<String>
    private lateinit var buttonBox: StrongBox<Int>
    private lateinit var dialBox: StrongBox<String>
    private lateinit var fingerBox: StrongBox<Double>

    @Before
    fun setUp() {
        padlockBox = StrongBox(KeyType.PADLOCK)
        buttonBox = StrongBox(KeyType.BUTTON)
        dialBox = StrongBox(KeyType.DIAL)
        fingerBox = StrongBox(KeyType.FINGER)
    }

    @Test
    fun `초기 호출은 null 리턴`() {
        padlockBox.put("Treasure")
        assertNull(padlockBox.get())
    }

    @Test
    fun `열쇠가 Padlock인 경우`() {
        padlockBox.put("Treasure")
        repeat(1_024) { assertNull(padlockBox.get()) }
        assertEquals("Treasure", padlockBox.get())
    }

    @Test
    fun `열쇠가 Button인 경우`() {
        buttonBox.put(42)
        repeat(10_000) { assertNull(buttonBox.get()) }
        assertEquals(42, buttonBox.get())
    }

    @Test
    fun `열쇠가 Dial인 경우`() {
        dialBox.put("Secret Document")
        repeat(30_000) { assertNull(dialBox.get()) }
        assertEquals("Secret Document", dialBox.get())
    }

    @Test
    fun `열쇠가 Finger인 경우`() {
        fingerBox.put(3.14159)
        repeat(1_000_000) { assertNull(fingerBox.get()) }
        assertEquals(3.14159, fingerBox.get())
    }

    @Test
    fun `아무것도 넣지 않은 금고`() {
        val emptyBox = StrongBox<String>(KeyType.DIAL)
        assertNull(emptyBox.get())
        repeat(30_000) { assertNull(emptyBox.get()) }
        assertNull(emptyBox.get())
    }

    @Test
    fun `금고에는 1개의 인스턴스만 담을 수 있다`() {
        padlockBox.put("Treasure")
        padlockBox.put("Diamond")
        repeat(1_024) { assertNull(padlockBox.get()) }
        assertEquals("Diamond", padlockBox.get())
    }
}
package day10

import org.example.day10.KeyType
import org.example.day10.StrongBox
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class StrongBoxTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `StrongBox에 들어갈 수 있는 인스턴스는 1개다`() {
        val strongBox: StrongBox<Any> = StrongBox(KeyType.FINGER)
        val something1: Any = "money"
        val something2: Any = "gold"
        strongBox.put(something1)
        assertThrows(IllegalArgumentException::class.java) {
            strongBox.put(something2)
        }
    }

    @Test
    fun `StrongBox에서 사용할 KeyType별 시도횟수 한도 체크`() {
        val strongBox1: StrongBox<Any> = StrongBox(KeyType.PADLOCK)
        val strongBox2: StrongBox<Any> = StrongBox(KeyType.BUTTON)
        val strongBox3: StrongBox<Any> = StrongBox(KeyType.DIAL)
        val strongBox4: StrongBox<Any> = StrongBox(KeyType.FINGER)

        assertEquals(1024, strongBox1.getMaxTryCount())
        assertEquals(10000, strongBox2.getMaxTryCount())
        assertEquals(30000, strongBox3.getMaxTryCount())
        assertEquals(1000000, strongBox4.getMaxTryCount())
    }

    @Test
    fun `StrongBox에서 KeyType별 시도횟수 한도 도달전 null 리턴 도달후 인스턴스 정보 리턴 체크`() {
        val strongBox1: StrongBox<Any> = StrongBox(KeyType.PADLOCK)
        val strongBox2: StrongBox<Any> = StrongBox(KeyType.BUTTON)
        val strongBox3: StrongBox<Any> = StrongBox(KeyType.DIAL)
        val strongBox4: StrongBox<Any> = StrongBox(KeyType.FINGER)
        val something = "Money"

        strongBox1.put(something)
        strongBox2.put(something)
        strongBox3.put(something)
        strongBox4.put(something)

        for (i: Int in 1..1024) {
            assertEquals(null, strongBox1.get())
        }
        assertEquals(1024, strongBox1.getTryCount())
        assertEquals(0, strongBox1.getMaxTryCount())
        assertEquals("Money", strongBox1.get())

        for (i: Int in 1..10000) {
            assertEquals(null, strongBox2.get())
        }
        assertEquals(10000, strongBox2.getTryCount())
        assertEquals(0, strongBox2.getMaxTryCount())
        assertEquals("Money", strongBox2.get())

        for (i: Int in 1..30000) {
            assertEquals(null, strongBox3.get())
        }
        assertEquals(30000, strongBox3.getTryCount())
        assertEquals(0, strongBox3.getMaxTryCount())
        assertEquals("Money", strongBox3.get())

        for (i: Int in 1..1000000) {
            assertEquals(null, strongBox4.get())
        }
        assertEquals(1000000, strongBox4.getTryCount())
        assertEquals(0, strongBox4.getMaxTryCount())
        assertEquals("Money", strongBox4.get())
    }
}
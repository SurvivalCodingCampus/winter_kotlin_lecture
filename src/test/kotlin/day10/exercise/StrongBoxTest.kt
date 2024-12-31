package day10.exercise

import org.junit.Test

import org.junit.Assert.*

class StrongBoxTest {

    // PADLOCK 테스트
    @Test
    fun `키타입이 PADLOCK인 경우`() {
        val keyType = KeyType.PADLOCK
        val strongBox = StrongBox<String>(keyType)
        strongBox.put("치킨")

        for (i in 1..keyType.tryCount) {
            if (i <= keyType.tryCount - 1) assertEquals(null, strongBox.get())
            if (i == keyType.tryCount) assertEquals("치킨", strongBox.get())
        }
    }

    // PADLOCK 테스트
    @Test
    fun `키타입이 Button 경우`() {
        val keyType = KeyType.BUTTON
        val strongBox = StrongBox<Int>(keyType)
        strongBox.put(30)

        for (i in 1..keyType.tryCount) {
            if (i <= keyType.tryCount - 1) assertEquals(null, strongBox.get())
            if (i == keyType.tryCount) assertEquals(30, strongBox.get())
        }
    }

    // PADLOCK 테스트
    @Test
    fun `키타입이 DIAL 경우`() {
        val keyType = KeyType.DIAL
        val strongBox = StrongBox<Boolean>(keyType)
        strongBox.put(true)

        for (i in 1..keyType.tryCount) {
            if (i <= keyType.tryCount - 1) assertEquals(null, strongBox.get())
            if (i == keyType.tryCount) assertEquals(true, strongBox.get())
        }
    }

    // PADLOCK 테스트
    @Test
    fun `키타입이 FINGER 경우`() {
        val keyType = KeyType.FINGER
        val strongBox = StrongBox<Double>(keyType)
        strongBox.put(100.0)
        for (i in 1..keyType.tryCount) {
            if (i <= keyType.tryCount - 1) assertEquals(null, strongBox.get())
            if (i == keyType.tryCount) assertEquals(100.0, strongBox.get())
        }
    }

}
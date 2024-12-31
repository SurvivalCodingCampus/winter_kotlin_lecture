package day10

import org.example.TestOnlyMethod
import org.example.day10.KeyType
import org.example.day10.StrongBox
import org.junit.Assert.*
import org.junit.Test

@OptIn(TestOnlyMethod::class)
class StrongBoxTest {
    @Test
    fun put() {
        val testString = "Hello"
        val testKeyType = KeyType.padlock
        var strongBox = StrongBox<String>(testKeyType)
        assertTrue("put 이전에 item 값이 세팅 되어 있지 않아야 한다.", !strongBox.isSetItem())
        assertTrue("put 이전에 시도 횟수가 0 이어야 한다.", strongBox.getTrialCount() == 0)
        assertEquals("선언 되었을 때의 키 타입을 가지고 있어야 한다.", testKeyType, strongBox.getKeyType())
        strongBox.put(testString)
        assertTrue("put 이후에 item 값이 세팅 되어야 한다.", strongBox.isSetItem())
    }

    @Test
    fun get() {
        val testString = "Hello"

       KeyType.entries.forEach {
           val strongBox = StrongBox<String>(it)
           strongBox.put(testString)
           println("KeyType: ${it}, trialLimit: ${it.trialLimit}")
           strongBox.setTrialCount(0)
           assertNull("시도 횟수가 0 일 때는 null 이어야 한다.", strongBox.get())
           assertNull("시도 횟수가 1 일 때는 null 이어야 한다.", strongBox.get())
           strongBox.setTrialCount(it.trialLimit - 1)
           assertNull("시도 횟수가 trialLimit - 1 일 때는 null 이어야 한다.", strongBox.get())
           assertTrue("시도 횟수가 trialLimit 에 도달 하면 값을 반환 해야 한다.", strongBox.get() == testString)
       }
    }

}
package day10

import org.example.day10.KeyType
import org.example.day10.StrongBox
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class StrongBoxTest {

    @Test
    fun `put() - 금고에 이미 데이터가 있을 경우 예외를 발생시켜야 함`() {
        val strongBox = StrongBox<String>(keyType = KeyType.padlock)
        strongBox.put("사과")


        val exception = assertThrows<IllegalStateException> {
            strongBox.put("바나나")
        }

        assertEquals("금고에 이미 물건이 있습니다.", exception.message)
    }

    @Test
    fun `get() - 잠금해제 횟수 테스트 KeyTpye이 padlock 일 때, get() 호출 1024회 전 까지는 null, 1024회 이후로는 '사과'를 리턴해야 한다`() {
        val strongBox = StrongBox<String>(keyType = KeyType.padlock)
        strongBox.put("사과")

        // 1024번째 호출 전까지는 null 반환
        for (i in 0..1023) {
            val result = strongBox.get()
            assertNull(result)
        }

        // 1024번째 호출에서는 "사과" 반환
        val resultAfterUnlock = strongBox.get()
        assertEquals("사과", resultAfterUnlock)
    }

    @Test
    fun `get() - 잠금해제 횟수 테스트 KeyTpye이 button 일 때, get() 호출 10,000회 전 까지는 null, 10,000회 이후로는 '사과'를 리턴해야 한다`() {
        val strongBox = StrongBox<String>(keyType = KeyType.button)
        strongBox.put("사과")

        // 10,000번째 호출 전까지는 null 반환
        for (i in 0..9999) {
            val result = strongBox.get()
            assertNull(result)
        }

        // 10,000번째 호출에서는 "사과" 반환
        val resultAfterUnlock = strongBox.get()
        assertEquals("사과", resultAfterUnlock)

    }

    @Test
    fun `get() - 잠금해제 횟수 테스트 KeyTpye이 dial 일 때, get() 호출 30,000회 전 까지는 null, 30,000회 이후로는 '사과'를 리턴해야 한다`() {
        val strongBox = StrongBox<String>(keyType = KeyType.dial)
        strongBox.put("사과")

        // 30,000번째 호출 전까지는 null 반환
        for (i in 0..29999) {
            val result = strongBox.get()
            assertNull(result)
        }

        // 30,000번째 호출에서는 "사과" 반환
        val resultAfterUnlock = strongBox.get()
        assertEquals("사과", resultAfterUnlock)

    }

    @Test
    fun `get() - 잠금해제 횟수 테스트 KeyTpye이 finger 일 때, get() 호출 1,000,000회 전 까지는 null, 1,000,000회 이후로는 '사과'를 리턴해야 한다`() {
        val strongBox = StrongBox<String>(keyType = KeyType.finger)
        strongBox.put("사과")

        // 1,000,000번째 호출 전까지는 null 반환
        for (i in 0..999999) {
            val result = strongBox.get()
            assertNull(result)
        }

        // 1,000,000번째 호출에서는 "사과" 반환
        val resultAfterUnlock = strongBox.get()
        assertEquals("사과", resultAfterUnlock)

    }
}

package day10

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull


class StrongBoxTest {
    @Test
    fun `각 KeyType별로 최대 시도횟수 도달 전 null반환 및 도달 후 내용물 get 확인`() {
        KeyType.entries.forEach { keyType ->
            val box = StrongBox<String>(keyType)

            box.put("goldBar")

            repeat(keyType.maxAttempts) {
                assertNull(box.get())
            }

            assertEquals("goldBar", box.get())
        }
    }

}
package day10

import org.junit.Assert
import org.junit.Test

class StrongBoxTest {
    @Test
    fun `lifespan test`() {
        val content = "value"
        val safeList = KeyType.entries.associateWith {
            StrongBox<String>(it).apply { put(content) }
        }

        safeList.entries.forEach {
            var cnt = it.key.lifespan
            while (--cnt > 0) {
                Assert.assertEquals("count: $cnt", null, it.value.get())
            }
            Assert.assertEquals(content, it.value.get())
        }
    }
}
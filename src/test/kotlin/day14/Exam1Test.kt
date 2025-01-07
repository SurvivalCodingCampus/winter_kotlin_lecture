package day14

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.day14.TodoDataSourceImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class Exam1Test {
    private val json = """
    {
      "userId": 1,
      "id": 1,
      "title": "delectus aut autem",
      "completed": false
    }
""".trimIndent()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `연습문제 1번 테스트`() = runBlocking {
        val test = TodoDataSourceImpl()

        val job = launch {
            assertEquals(1, test.getTodo()[0].userId)
            assertEquals(1, test.getTodo()[0].id)
            assertEquals("delectus aut autem", test.getTodo()[0].title)
            assertEquals(false, test.getTodo()[0].completed)
        }
    }

    @Test
    fun `연습문제 2번 테스트`() = runBlocking {
        val test = TodoDataSourceImpl()

        val job = launch {
            assertEquals(1, test.getTodo()[0].userId)
            assertEquals(1, test.getTodo()[0].id)
            assertEquals("delectus aut autem", test.getTodo()[0].title)
            assertEquals(false, test.getTodo()[0].completed)

            assertEquals(1, test.getTodo()[1].userId)
            assertEquals(2, test.getTodo()[1].id)
            assertEquals("quis ut nam facilis et officia qui", test.getTodo()[1].title)
            assertEquals(false, test.getTodo()[1].completed)
        }
    }
}
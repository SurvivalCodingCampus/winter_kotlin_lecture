package day16

import day14.practice_problem_01.Todo
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalArgumentException
import kotlin.test.assertFailsWith

class MockTodoRepositoryImplTest {

    @Test
    fun getTodo() = runBlocking {
        val mockTodoRepositoryImpl = MockTodoRepositoryImpl(MockTodoDataSourceImpl())

        val check = """
            {
                "userId": 1,
                "id": 1,
                "title": "delectus aut autem",
                "completed": false
            }
        """.trimIndent()

        assertEquals(Json.decodeFromString<Todo>(check), mockTodoRepositoryImpl.getTodo(1))
    }

    @Test
    fun getTodos() = runBlocking {
        val mockTodoRepositoryImpl = MockTodoRepositoryImpl(MockTodoDataSourceImpl())

        val data = mockTodoRepositoryImpl.getTodos()

        assertEquals(200, data.size)
    }

    @Test
    fun `네트워크 에러 테스트`() = runBlocking {
        val client = HttpClient(MockTodoDataSourceImpl().mockEngine)

        val response = client.get("test-network-error")
        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    fun `존재하지 않는 ID 요청 테스트`(): Unit = runBlocking {
        val mockTodoRepositoryImpl = MockTodoRepositoryImpl(MockTodoDataSourceImpl())
        val client = HttpClient(MockTodoDataSourceImpl().mockEngine)

        assertFailsWith<IllegalArgumentException> {
            mockTodoRepositoryImpl.getTodo(2)
        }
    }
}
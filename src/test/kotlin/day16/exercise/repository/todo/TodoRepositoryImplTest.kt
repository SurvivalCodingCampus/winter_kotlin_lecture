package day16.exercise.repository.todo

import day16.exercise.datasource.todo.TodoDataSourceImpl
import day16.util.HttpClientFactory
import day16.util.mockEngine
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class TodoRepositoryImplTest {

    private lateinit var todoRepositoryImpl: TodoRepositoryImpl

    private lateinit var httpClient: HttpClient

    @Before
    fun setUp() {

        httpClient = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }

        todoRepositoryImpl = TodoRepositoryImpl(
            TodoDataSourceImpl(
                httpClient
            )
        )
    }

    @Test
    fun `getTodos 가져오기`() = runTest {
        val result = todoRepositoryImpl.getTodos()
        println(result)
        assertEquals(2, result.size)
    }


}
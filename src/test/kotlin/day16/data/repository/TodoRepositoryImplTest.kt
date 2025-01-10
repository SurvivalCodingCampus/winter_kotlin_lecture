package day16.data.repository

import day16.data.mock.todoMockEngine
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult
import org.example.day14.util.jsonConfig
import org.example.day16.data.datasource.TodoDataSourceImpl
import org.example.day16.data.repository.TodoRepositoryImpl
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TodoRepositoryImplTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: TodoRepositoryImpl
    private lateinit var httpClient: HttpClient

    @Before
    fun setUp() {
        httpClient = HttpClient(todoMockEngine) {
            install(ContentNegotiation) {
                json(jsonConfig)
            }
        }
        subject = TodoRepositoryImpl(
            TodoDataSourceImpl(
                httpClient
            )
        )
    }


    @Test
    fun getTodo() = testScope.runTest {
        // id는 1 이상이어야 한다
        subject.getTodo(0).asResult().filterNot { it is Result.Loading }.collect { result ->
            assertTrue(result is Result.Error)
            assertTrue(result.exception.toString().contains("400 Bad Request"))
            assertTrue(result.exception is NoTransformationFoundException)
        }

        // 시작 id 테스트
        subject.getTodo(1).asResult().filterNot { it is Result.Loading }.collect { result ->
            assertTrue(result is Result.Success)
            assertEquals(1, result.data.id)
        }

        // 마지막으로 예상되는 id 테스트
        subject.getTodo(200).asResult().filterNot { it is Result.Loading }.collect { result ->
            assertTrue(result is Result.Success)
            assertEquals(200, result.data.id)
        }

        // 데이터 보다 id가 더 큰 경우
        subject.getTodo(201).asResult().filterNot { it is Result.Loading }.collect { result ->
            assertTrue(result is Result.Error)
            assertTrue(result.exception.toString().contains("404 Not Found"))
            assertTrue(result.exception is NoTransformationFoundException)
        }
    }

    @Test
    fun getTodos() = testScope.runTest {
        subject.getTodos().asResult().filterNot { it is Result.Loading }.collect { result ->
            assertTrue(result is Result.Success)
            assertEquals(2, result.data.size)
        }
    }

}
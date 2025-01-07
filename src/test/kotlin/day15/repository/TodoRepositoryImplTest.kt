package day15.repository

import day15.data_source.MockTodoDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class TodoRepositoryImplTest {

    @Test
    fun `모든 Todo JSON 데이터를 가져오는지 확인`() = runTest {
        val repository = TodoRepositoryImpl(MockTodoDatasourceImpl())
        val todos = repository.getTodos()

        assertEquals(200, todos.size)
    }

    @Test
    fun `completed true인 JSON 데이터만 가져오는지 확인`() = runTest {
        val repository = TodoRepositoryImpl(MockTodoDatasourceImpl())
        val todos = repository.getCompletedTodos()

        assertEquals(90, todos.size)
    }
}
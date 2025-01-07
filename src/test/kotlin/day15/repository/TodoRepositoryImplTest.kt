package day15.repository

import kotlinx.coroutines.runBlocking
import org.example.day15.data_source.TodoDataSource
import org.example.day15.data_source.TodoDataSourceImpl
import org.example.day15.repository.TodoRepositoryImpl
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TodoRepositoryImplTest {

    private lateinit var mockDataSource: TodoDataSource
    private lateinit var repository: TodoRepositoryImpl

    @Before
    fun setup() {
        mockDataSource = TodoDataSourceImpl()
        repository = TodoRepositoryImpl(mockDataSource)
    }

    @Test
    fun `getTodos size는 200이 나와야 한다`() = runBlocking {
        val todos = repository.getTodos()
        assertEquals(200, todos.size)
    }

    @Test
    fun `getCompletedTodos의 모든 completed 값은 true여야 한다`() = runBlocking {
        val completedTodos = repository.getCompletedTodos()

        assertEquals(true, completedTodos[0].completed)
        assertEquals(true, completedTodos[1].completed)
        assertEquals(true, completedTodos[2].completed)
    }

}
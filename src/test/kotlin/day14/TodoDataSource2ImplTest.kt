package day14

import org.junit.Assert.*
import org.junit.Test
import kotlinx.coroutines.runBlocking
import org.example.day14.TodoDataSource2Impl

class TodoDataSource2ImplTest {

    private val todoDataSource = TodoDataSource2Impl()

    @Test
    fun `getTodos 데이터가 일치하는지 테스트 `() = runBlocking {
        val todos = todoDataSource.getTodos()

        val firstTodo = todos[0]
        assertEquals(1, firstTodo.userId)
        assertEquals(1, firstTodo.id)
        assertEquals("delectus aut autem", firstTodo.title)
        assertFalse(firstTodo.completed)
    }

    @Test
    fun `getTodos 데이터가 200개가 맞는지 확인`() = runBlocking {
        val todos = todoDataSource.getTodos()
        assertEquals(200, todos.size)
    }
}
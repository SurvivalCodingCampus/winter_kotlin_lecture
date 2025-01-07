package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.test.asserter

class TodoRepositoryImplTest {

    @Test
    fun getTodos() = runBlocking {
        val data = TodoRepositoryImpl(MockTodoDataSourceImpl()).getTodos()

        assertEquals(200, data.size)
    }

    @Test
    fun getCompletedTodos() = runBlocking{
        val data = TodoRepositoryImpl(MockTodoDataSourceImpl()).getCompletedTodos()

        for(i in data.indices) {
            assertEquals(true, data[i].completed)
        }
    }
}
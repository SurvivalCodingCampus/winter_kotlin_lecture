package day14.practice_problem_01_test

import day14.practice_problem_01.Todo
import day14.practice_problem_01.TodoDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.test.todo

class TodoDataSourceImplTest {

    @Test
    fun getTodo() = runBlocking {
        val todoData: Todo = TodoDataSourceImpl().getTodo()

        assertEquals(1, todoData.id)
        assertEquals(1, todoData.userId)
        assertEquals("delectus aut autem", todoData.title)
        assertEquals(false, todoData.completed)
    }
}
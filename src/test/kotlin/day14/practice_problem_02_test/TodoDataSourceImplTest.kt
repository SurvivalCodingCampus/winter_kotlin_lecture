package day14.practice_problem_02_test

import day14.practice_problem_02.Todo
import day14.practice_problem_02.TodoDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class TodoDataSourceImplTest {

    @Test
    fun getTodo() = runBlocking {
        val todoDataList: List<Todo> = TodoDataSourceImpl().getTodo()

        assertEquals(200, todoDataList.size)
    }
}
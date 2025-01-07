package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.TodoDatasourceImpl
import org.example.day15.repository_exam.repository.TodoRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam3Test {
    private val test = TodoRepositoryImpl(TodoDatasourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `getTodos() 테스트`() = runBlocking {

        // 가져온 Todo 개수 확인
        assertEquals(200, test.getTodos().size)

        // 가져온 Todo에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getTodos()[0].userId)
        assertEquals(1, test.getTodos()[0].id)
        assertEquals("delectus aut autem", test.getTodos()[0].title)
        assertEquals(false, test.getTodos()[0].completed)
    }

    @Test
    fun `getCompletedTodos() 테스트`() = runBlocking {

        // 가져온 Todo 개수 확인
        assertEquals(90, test.getCompletedTodos().size)

        // 가져온 Todo들의 completed가 true인가 확인 (모두 true인가)
        assertEquals(90, test.getCompletedTodos().filter { it.completed }.size)

        // 가져온 Todo에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getCompletedTodos()[0].userId)
        assertEquals(4, test.getCompletedTodos()[0].id)
        assertEquals("et porro tempora", test.getCompletedTodos()[0].title)
        assertEquals(true, test.getCompletedTodos()[0].completed)
    }
}
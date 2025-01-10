package day16.repository_exam.repository.todo

import day16.repository_exam.data_source.MockTodoDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class TodoRepositoryImplTest() {
    private val todoRepository = TodoRepositoryImpl(MockTodoDataSourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `MockTododataSourceImpl로 테스트`() = runTest {
        println(todoRepository.getTodos())
    }
}
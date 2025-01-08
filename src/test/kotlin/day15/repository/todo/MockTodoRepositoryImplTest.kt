package day15.repository.todo

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import kotlin.test.Test

//class MockTodoRepositoryImplTest {
//
//    private val mockTodoRepositoryImpl = MockTodoRepositoryImpl(MockTodoDataSourceImpl())
//
//    @Test
//    fun `Todo 전체 리스트 불러오기 size 확인`() = runBlocking {
//        val result = mockTodoRepositoryImpl.getTodos()
//
//        assertEquals(200, result.size)
//    }
//
//    @Test
//    fun `Todo 리스트에서 Completed가 true인 데이터의 size및 데이터 확인`() = runBlocking {
//        val result = mockTodoRepositoryImpl.getCompletedTodos()
//
//        result.forEach { todo ->
//            assertEquals(todo.completed, true)
//        }
//
//        assertEquals(90, result.size)
//    }
//
//
//}
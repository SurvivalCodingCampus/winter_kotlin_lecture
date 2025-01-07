package day14

import kotlinx.coroutines.test.runTest
import kotlin.test.*

class TodoDataSourceImplTest {

    /*@Test
    fun `JSON이 데이터클래스로 올바르게 변환되는지 확인`() = runTest {
        val todoData = TodoDataSourceImpl()
        val todo = todoData.getTodo()

        assertEquals(1, todo.userId)
        assertEquals(1, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertEquals(false, todo.completed)
    }*/

    @Test
    fun `JSON이 데이터클래스 리스트로 변환되는지 확인`() = runTest {
        val todoData = TodoDataSourceImpl()
        val jsonList = todoData.getTodo()

        assertNotNull(jsonList)
        assertTrue(jsonList is List<Todo>)
        assertEquals(199, jsonList.lastIndex)
    }
}
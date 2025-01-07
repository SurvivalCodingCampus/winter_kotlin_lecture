package day14.exercise.todo

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

//class TodoDataSourceImplTest {
//
//
//    @Test
//    fun `간단한 JSON을 데이터 클래스로 변환하였을때 잘 되었는지 확인`() = runTest {
//        val todoDataSourceImpl = TodoDataSourceImpl()
//        val result = todoDataSourceImpl.getTodo()
//        result.apply {
//            assertEquals(1, userId)
//            assertEquals(1, id)
//            assertEquals("delectus aut autem", title)
//            assertEquals(false, completed)
//        }
//    }
//
//    @Test
//    fun `Json List를 List Todo 로 변환하여 잘되었는지 테스트`() = runTest {
//        val todoDataSourceImpl = TodoDataSourceImpl()
//        val result = todoDataSourceImpl.getTodos()
//
//        assertEquals(200, result.size)
//    }
//
//}
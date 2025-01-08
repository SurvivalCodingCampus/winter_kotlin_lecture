package day15.repository

import day15.data_source.MockCommentDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class CommentRepositoryImplTest {
    @Test
    fun `postId에 일치하는 Json데이터를 가져오는지 확인`() = runTest {
        val repository = CommentRepositoryImpl(MockCommentDatasourceImpl())
        val comment = repository.getComments(1)

        assertEquals(5, comment.size)
    }

    @Test
    fun `postId가 범위 밖에 있는 경우 빈 리스트를 가져오는지 확인`() = runTest {
        val repository = CommentRepositoryImpl(MockCommentDatasourceImpl())
        val comment1 = repository.getComments(0)
        val comment2 = repository.getComments(-1)

        assertEquals(0, comment1.size)
        assertEquals(0, comment2.size)
    }

    @Test
    fun `존재하지 않는 postId인 경우 빈 리스트를 반환한다`() = runTest {
        val repository = CommentRepositoryImpl(MockCommentDatasourceImpl())
        val comments = repository.getComments(-1)
        assertTrue(comments.isEmpty())
    }

    @Test
    fun `반환된 댓글의 postId가 요청한 postId와 일치하는지 확인`() = runTest {
        val repository = CommentRepositoryImpl(MockCommentDatasourceImpl())
        val postId = 1
        val comments = repository.getComments(postId)

        assertTrue(comments.all { it.postId == postId })
    }

    @Test
    fun `데이터 소스에서 예외 발생시 적절히 처리되는지 확인`() = runTest {
        val mockDataSource = MockCommentDatasourceImpl(shouldThrowException = true)
        val repository = CommentRepositoryImpl(mockDataSource)

        assertFailsWith<Exception> {
            repository.getComments(1)
        }
    }

}
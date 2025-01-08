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

}
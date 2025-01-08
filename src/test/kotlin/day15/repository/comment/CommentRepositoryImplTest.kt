package day15.repository.comment

import day15.data_source.comment.MockCommentDataSourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals


class CommentRepositoryImplTest {


  @Test
  fun `데이터 size 체크`() = runTest {
    val commentRepositoryImpl = CommentRepositoryImpl(MockCommentDataSourceImpl())


    val result = commentRepositoryImpl.getComments(1)

    // postId 1을 넣을 경우 5개 담겨 있음
    assertEquals(5, result.size)
  }
}
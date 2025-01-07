package day15.repository.comment

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.comment.MockCommentDataSourceImpl
import org.example.day15.repository.comment.CommentRepositoryImpl
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CommentRepositoryImplTest {
    private val jsonWithInvalidField = """
        [
            {
                "postId": 1,
                "id": 1,
                "name": "id labore ex et quam laborum",
                "title": "title",
                "email": ""
            },
        ]
    """.trimIndent()

    private val invalidJson = """
        [
            {
                "postId": 1,
                "id": 1,
                "name": "id labore ex et quam laborum",
                "title": "title",
                "email": "
            }
        ]
    """.trimIndent()
    val validCommentRepositoryImpl = CommentRepositoryImpl(MockCommentDataSourceImpl())

    @Test
    fun getComments(): Unit = runBlocking {
        val postId = 1
        val comments = validCommentRepositoryImpl.getComments(postId)
        Assert.assertTrue("댓글 정보는 5개 여야 한다.", comments.size == 5)
        Assert.assertTrue("첫번째 댓글의 postId는 1이여야 한다.", comments.first().postId == postId)

        val invalidCommentRepositoryImpl = CommentRepositoryImpl(MockCommentDataSourceImpl(jsonWithInvalidField))
        val commentsWithInvalidField =
            assertDoesNotThrow("잘못된 필드가 있어도 default 객체를 반환 해야 한다.") { invalidCommentRepositoryImpl.getComments(postId) }
        Assert.assertTrue("댓글 정보는 0개 여야 한다.", commentsWithInvalidField.size == 1)

        val errorCommentRepositoryImpl = CommentRepositoryImpl(MockCommentDataSourceImpl(invalidJson))

        // assertThrows 는 suspend fun 을 지원하지 않기 때문에
        // suspend fun 의 에러를 체크 해야 할 때는 suspend fun 을 launch 와 같은 suspend fun 으로 감싸서 체크 해야 한다.
        launch {
            assertThrows<SerializationException> { errorCommentRepositoryImpl.getComments(postId) }
        }.start()
    }

}
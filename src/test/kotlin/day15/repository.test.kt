package day15

import MockCommentDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day15.Model.Comment
import org.example.day15.Repository.CommentDataSourceImpl
import org.example.day15.Repository.CommentRepository
import org.example.day15.Utils.format
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


class CommentRepositoryTest {
    @Test
    fun `comment mock test`(): Unit = runTest {

        val mockData = format.encodeToString<List<Comment>>(
            listOf(
                Comment(
                    id = 1,
                    name = "steve",
                    email = "dididid@gmail.com",
                    postId = 3,
                    body = "hello"
                )
            )
        )

        val emptyData =
            """
            []
        """.trimIndent()

        val emptyResult = CommentDataSourceImpl(emptyData).getComments(3)
        val mockDataSourceResult = CommentDataSourceImpl(mockData).getComments(3)
        val originDataSourceResult = CommentRepository().getComments(3)


        assertEquals(1, mockDataSourceResult.size)
        assertEquals("steve", mockDataSourceResult.last().name)
        assertEquals(0, emptyResult.size)
        assertEquals(5, originDataSourceResult.size)
    }
}


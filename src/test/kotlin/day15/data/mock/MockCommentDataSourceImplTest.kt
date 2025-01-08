package day15.data.mock

import kotlinx.coroutines.test.runTest
import org.example.day14.util.jsonConfig
import org.example.day15.data.mock.MockCommentDataSourceImpl
import org.example.day15.data.model.Comment
import org.example.day15.data.resource.commentsJsonString
import org.junit.Test

import org.junit.Assert.*

class MockCommentDataSourceImplTest {
    private val mockDataList = jsonConfig.decodeFromString<List<Comment>>(commentsJsonString)

    @Test
    fun getComments() = runTest {
        val postId = 1
        MockCommentDataSourceImpl().getComments(postId)
        //assertEquals(mockDataList[postId], MockCommentDataSourceImpl().getComments(postId))
    }
}
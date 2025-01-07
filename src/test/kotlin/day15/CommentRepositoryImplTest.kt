package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class CommentRepositoryImplTest {

    @Test
    fun getComments() = runBlocking {
        val data = CommentRepositoryImpl(MockCommentDataSourceImpl()).getComments(1)

        for(i in data.indices) {
            assertEquals(1, data[i].postId)
        }
    }
}
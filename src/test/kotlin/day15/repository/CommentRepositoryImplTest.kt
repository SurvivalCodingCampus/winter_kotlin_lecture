package day15.repository

import kotlinx.coroutines.runBlocking
import org.example.day15.data_source.CommentDataSource
import org.example.day15.data_source.CommentDataSourceImpl
import org.example.day15.repository.CommentRepository
import org.example.day15.repository.CommentRepositoryImpl
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class CommentRepositoryImplTest {

    private lateinit var repository: CommentRepository
    private lateinit var mockDataSource: CommentDataSource

    @Before
    fun setup() {
        mockDataSource = CommentDataSourceImpl()
        repository = CommentRepositoryImpl(mockDataSource)
    }

    @Test
    fun `postId 1을 넣을 경우 5가 나와야 한다`() = runBlocking {
        val postId = 1
        val comments = repository.getComments(postId)
        assertEquals(5, comments.size)
    }

    @Test
    fun `postId가 없는 경우 0이 나와야 한다`() = runBlocking {
        val postId = 999
        val comments = repository.getComments(postId)
        assertEquals(0, comments.size)
    }
}
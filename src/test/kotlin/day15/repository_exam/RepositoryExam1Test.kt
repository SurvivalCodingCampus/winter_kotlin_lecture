package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockCommentDatasourceImpl
import org.example.day15.repository_exam.repository.CommentRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam1Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `MockCommentDatasourceImpl로 getComments() 테스트`() = runBlocking {
        val testMock = CommentRepositoryImpl(MockCommentDatasourceImpl())

        // 가져온 Comment 개수 확인
        assertEquals(5, testMock.getComments(1).size)
        assertEquals(5, testMock.getComments(2).size)
        assertEquals(5, testMock.getComments(3).size)

        // 가져온 Comment에서 원하는 데이터가 나오는지 확인
        assertEquals(1, testMock.getComments(1)[0].postId)
        assertEquals(1, testMock.getComments(1)[0].id)
        assertEquals("id labore ex et quam laborum", testMock.getComments(1)[0].name)
        assertEquals("Eliseo@gardner.biz", testMock.getComments(1)[0].email)
        assertEquals(
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\n" +
                    "tempora quo necessitatibus\n" +
                    "dolor quam autem quasi\n" +
                    "reiciendis et nam sapiente accusantium", testMock.getComments(1)[0].body
        )

    }
}
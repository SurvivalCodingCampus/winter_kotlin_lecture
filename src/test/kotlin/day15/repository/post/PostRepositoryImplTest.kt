package day15.repository.post

import day15.data_source.post.MockPostDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals


class PostRepositoryImplTest {
    private val postRepositoryImpl = PostRepositoryImpl(MockPostDataSourceImpl())

    @Test
    fun `단일 포스트 확인`() = runBlocking {
        val result = postRepositoryImpl.getPost(1)

        // 불러온 데이터의 id가 1인지
        assertEquals(1, result?.id ?: 0)
    }

    @Test
    fun `전체 포스트 확인`() = runBlocking {
        val result = postRepositoryImpl.getPosts()

        assertEquals(100, result.size)
    }

    @Test
    fun `페이지 네이션 확인`() = runBlocking {
        val page1 = postRepositoryImpl.getPosts(page = 1, limit = 3)
        val page2 = postRepositoryImpl.getPosts(page = 2, limit = 3)
        val page3 = postRepositoryImpl.getPosts(page = 3, limit = 3)


        // 사이즈 확인
        assertEquals(3, page1.size)
        assertEquals(3, page2.size)
        assertEquals(3, page3.size)


        // 들어있는 값 확인
        (0..2).forEachIndexed { idx, post ->
            assertEquals(idx + 1, page1[idx].id)
        }

        // 들어있는 값 확인
        (0..2).forEachIndexed { idx, post ->
            assertEquals(idx + 4, page2[idx].id)
        }

        // 들어있는 값 확인
        (0..2).forEachIndexed { idx, post ->
            assertEquals(idx + 7, page3[idx].id)
        }
    }

    @Test
     fun `잘못된 페이지 번호 1로 처리 확인`() = runBlocking {
        val result = postRepositoryImpl.getPosts(0, 3)

        assertEquals(3, result.size)
     }
}
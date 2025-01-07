package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.test.asserter

class PostRepositoryImplTest {

    @Test
    fun `전체 게시글 목록 조회`() = runBlocking {
        val allPosts = PostRepositoryImpl(PostDataSourceImpl()).getPosts()

        assertEquals(100, allPosts.size)
    }
    @Test
    fun `잘못된 페이지 번호 처리`() = runBlocking {
        // 잘못된 페이지 번호는 1로 처리
        val invalidPage = PostRepositoryImpl(PostDataSourceImpl()).getPosts(0, 3)

        for(i in 0..2) {
            assertEquals(i + 1, invalidPage[i].id)
        }
    }

    @Test
    fun getPost() = runBlocking {
        // 단일 포스트
        val data = PostRepositoryImpl(PostDataSourceImpl()).getPost(3)

        assertEquals(1, data.userId)
        assertEquals("ea molestias quasi exercitationem repellat qui ipsa sit aut", data.title)
        assertEquals("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut", data.body)

    }

    @Test
    fun `페이지 네이션의 정상적인 동작 확인 테스트`() = runBlocking {
        // 페이지 네이션
        val page1 = PostRepositoryImpl(PostDataSourceImpl()).getPosts(1, 3)
        val page2 = PostRepositoryImpl(PostDataSourceImpl()).getPosts(2, 3)
        val page3 = PostRepositoryImpl(PostDataSourceImpl()).getPosts(3, 3)

        assertEquals(3, page1.size)
        assertEquals(3, page2.size)
        assertEquals(3, page3.size)

        for(i in 0..2) {
            assertEquals(i + 1, page1[i].id)
        }
        for(i in 0..2) {
            assertEquals(i + 4, page2[i].id)
        }
        for(i in 0..2) {
            assertEquals(i + 7, page3[i].id)
        }

    }
}
package day15.repository

import day15.data_source.MockCommentDatasourceImpl
import day15.data_source.MockPostDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class PostRepositoryImplTest {
    private lateinit var repository: PostRepository

    @BeforeTest
    fun setup() {
        repository = PostRepositoryImpl(MockPostDatasourceImpl())
    }

    // 기본 성공 케이스
    @Test
    fun `모든 Post JSON 데이터를 가져오는지 확인`() = runTest {
        val posts = repository.getPosts()
        assertEquals(10, posts.size)
    }

    @Test
    fun `id에 맞는 Post를 가져오는지 확인`() = runTest {
        val post = repository.getPost(2)
        assertEquals(2, post.id)
    }

    // 예외 케이스 1: 존재하지 않는 ID
    @Test
    fun `존재하지 않는 ID로 조회시 예외가 발생하는지 확인`() = runTest {
        assertFailsWith<NoSuchElementException> {
            repository.getPost(999)
        }
    }

    // 예외 케이스 2: 잘못된 페이지 번호
    @Test
    fun `잘못된 페이지 번호로 조회시 첫 페이지를 반환하는지 확인`() = runTest {
        val postsWithZeroPage = repository.getPosts(0, 3)
        val postsWithNegativePage = repository.getPosts(-1, 3)

        assertEquals(3, postsWithZeroPage.size)
        assertEquals(3, postsWithNegativePage.size)
        assertEquals(postsWithZeroPage, postsWithNegativePage)
    }

    // 예외 케이스 3: 큰 limit 값
    @Test
    fun `limit이 전체 데이터보다 큰 경우 전체 데이터를 반환하는지 확인`() = runTest {
        val posts = repository.getPosts(1, 999)
        assertEquals(10, posts.size)  // 전체 데이터 크기
    }

    // 경계값 테스트 1: 마지막 페이지
    @Test
    fun `마지막 페이지 조회시 남은 데이터만 반환하는지 확인`() = runTest {
        val posts = repository.getPosts(4, 3)  // 10개 데이터의 마지막 페이지
        assertEquals(1, posts.size)  // 9개는 이전 페이지들에서 반환됨 (3+3+3=9)
    }

    // 경계값 테스트 2: 빈 페이지
    @Test
    fun `데이터가 없는 페이지 조회시 빈 리스트를 반환하는지 확인`() = runTest {
        val posts = repository.getPosts(5, 3)  // 데이터가 없는 페이지
        assertTrue(posts.isEmpty())
    }

}
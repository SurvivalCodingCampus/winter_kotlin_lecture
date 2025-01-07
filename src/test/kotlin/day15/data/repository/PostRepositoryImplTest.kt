package day15.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day14.util.jsonConfig
import org.example.day15.data.mock.MockPostDataSourceImpl
import org.example.day15.data.model.Post
import org.example.day15.data.repository.PostRepositoryImpl
import org.example.day15.data.resource.postsData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class PostRepositoryImplTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: PostRepositoryImpl
    private lateinit var postDataSource: MockPostDataSourceImpl
    private val posts = jsonConfig.decodeFromString<List<Post>>(postsData)

    @Before
    fun setUp() {
        postDataSource = MockPostDataSourceImpl()
        subject = PostRepositoryImpl(
            postDataSource = postDataSource
        )
    }

    @Test
    fun `getPost() id는 1이상 이어야 한다`() {
        // id는 1이상 부터 시작
        assertThrows(NoSuchElementException::class.java) {
            testScope.runTest {
                subject.getPost(0).first()
            }
        }
    }

    @Test
    fun `getPost(id) id는 데이터 수보다 작거나 같다`() {
        // id는 1이상 부터 시작
        assertThrows(NoSuchElementException::class.java) {
            testScope.runTest {
                subject.getPost(posts.size + 1).first()
            }
        }
    }

    @Test
    fun `getPost(id) 기본 동작 테스트`() = testScope.runTest {
        assertEquals(2, subject.getPost(2).first().id)
    }

    @Test
    fun `getPosts(page) page 1보다 작은 경우 page는 1 이다 `() = testScope.runTest {
        assertEquals(subject.getPosts(-1).first(), subject.getPosts(1).first())
    }

    @Test
    fun `getPosts(page, limit) limit가 있을 경우 page에 해당하는 limit 개수의 데이터가 나온다  `() =
        testScope.runTest {
            assertEquals(3, subject.getPosts(3, 3).first().size)
        }
}
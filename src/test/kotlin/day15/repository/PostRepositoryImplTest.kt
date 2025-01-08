package day15.repository

import day15.data_source.MockPostDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class PostRepositoryImplTest {

    @Test
    fun `모든 Post JSON 데이터를 가져오는지 확인`() = runTest {
        val repository:PostRepository = PostRepositoryImpl(MockPostDatasourceImpl())
        val post = repository.getPosts()

        assertEquals(10, post.size)
    }

    @Test
    fun `id에 맞는 Post를 가져오는지 확인`() = runTest {
        val repository:PostRepository = PostRepositoryImpl(MockPostDatasourceImpl())
        val post = repository.getPost(2)

        assertEquals(2, post.id)
    }

    @Test
    fun `페이징하여 Post JSON 데이터를 가져오는지 확인`() = runTest {
        val repository:PostRepository = PostRepositoryImpl(MockPostDatasourceImpl())
        val post = repository.getPosts(1,3)
        val post2 = repository.getPosts(2,3)
        
        assertEquals(3, post.size)
        assertEquals(3, post2.size)
    }

}
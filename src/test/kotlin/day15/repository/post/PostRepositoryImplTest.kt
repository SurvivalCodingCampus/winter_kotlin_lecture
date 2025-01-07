package day15.repository.post

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.day15.data_source.post.MockPostDataSourceImpl
import org.example.day15.repository.post.PostRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class PostRepositoryImplTest {
    val postRepository = PostRepositoryImpl(MockPostDataSourceImpl())

    @Test
    fun getPost(): Unit = runBlocking {
        val postId = 1
        val post = postRepository.getPost(postId)
        assertEquals("post 객체의 id는 1이여야 한다.", postId, post.id)

        val invalidPostId = 0
        launch {
            assertThrows<NoSuchElementException> { postRepository.getPost(invalidPostId) }
        }
    }

    @Test
    fun getPosts() = runBlocking {
        val posts = postRepository.getPosts()
        assertEquals("post 객체의 갯수는 100이여야 한다.", 100, posts.size)

        val page = 1
        val limit = 10
        val postsWithLimit = postRepository.getPosts(page, limit)
        assertEquals("post 객체의 갯수는 10이여야 한다.", 10, postsWithLimit.size)

        val invalidPage = 11
        val postsWithInvalidPage = postRepository.getPosts(invalidPage, limit)
        assertEquals("post 객체의 갯수는 0이여야 한다.", 0, postsWithInvalidPage.size)
    }

}
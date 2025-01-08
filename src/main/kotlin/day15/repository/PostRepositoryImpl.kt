package day15.repository

import day15.data_source.MockPostDatasourceImpl
import day15.data_source.PostDataSource
import day15.model.Post
import kotlinx.coroutines.runBlocking

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.getPost(id)
    }

    suspend fun getPosts(): List<Post> {
        return dataSource.getPosts()
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        // Todo : 페이지네이션
        val posts = dataSource.getPosts()
        val startIndex = (page - 1) * (limit ?: 10)
        val endIndex = startIndex + (limit ?: 10)

        // 페이지만큼 슬라이싱
        return posts.subList(startIndex, endIndex.coerceAtMost(posts.size))
    }
}

fun main() = runBlocking {
    val repository:PostRepository = PostRepositoryImpl(MockPostDatasourceImpl())
    val post = repository.getPosts()
    //val posts = repository.getPosts(2,3)
    //println(posts)
    println(post.size)

}
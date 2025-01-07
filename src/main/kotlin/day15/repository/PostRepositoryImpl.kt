package day15.repository

import day15.data_source.MockPostDatasourceImpl
import day15.data_source.PostDataSource
import day15.model.Post
import kotlinx.coroutines.runBlocking

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.getPost(id)
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        return dataSource.getPosts(page, limit)
    }
}

fun main() = runBlocking {
    val repository:PostRepository = PostRepositoryImpl(MockPostDatasourceImpl())
    //val post = repository.getPost(2)
    val posts = repository.getPosts()
    println(posts)
    //println(posts)
}
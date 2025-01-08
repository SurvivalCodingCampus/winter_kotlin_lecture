package day15.repository

import day15.data_source.PostDataSource
import day15.model.Post

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.postData().first{it.id == id}

    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        val page = if (page <= 0) 1 else page
        val offset = (page - 1) * limit!!
        return dataSource.postData().subList(offset, offset + limit)
    }

}
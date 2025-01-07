package org.hyunjung.day15.post.repository

import org.hyunjung.day15.post.datasource.PostDataSource
import org.hyunjung.day15.post.model.Post

class PostRepositoryImpl(
    private val dataSource: PostDataSource
) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.getPost(id)
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        val allPosts = dataSource.getPosts()
        val validatedPage = if (page < 1) 1 else page

        return if (limit != null) {
            val start = (validatedPage - 1) * limit
            val end = start + limit
            allPosts.subList(start.coerceAtMost(allPosts.size), end.coerceAtMost(allPosts.size))
        } else {
            allPosts
        }
    }
}
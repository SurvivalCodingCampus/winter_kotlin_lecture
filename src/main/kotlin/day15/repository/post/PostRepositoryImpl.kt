package org.example.day15.repository.post

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.post.PostDataSource
import org.example.day15.model.Post

class PostRepositoryImpl(
    override val postDataSource: PostDataSource,
) : PostRepository {
    override suspend fun getPost(id: Int): Post = withContext(Dispatchers.IO) {
        try {
            postDataSource.getPosts().first { it.id == id }
        } catch (e: Exception) {
            when (e) {
                is NoSuchElementException -> throw e
                is SerializationException -> throw e
                else -> Post(0, 0, "", "")
            }
        }

    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> = withContext(Dispatchers.IO) {
        try {
            postDataSource.getPosts().let { posts ->
                if (limit == null) {
                    posts
                } else {
                    if (page * limit > posts.size) {
                        emptyList()
                    } else {
                        posts.subList((page - 1) * limit, page * limit)
                    }
                }
            }
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }

    override suspend fun getPostsInfoList(): List<Post> = withContext(Dispatchers.IO) {
        try {
            postDataSource.getPosts()
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }
}
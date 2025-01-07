package org.hyunjung.day15.post.datasource

import org.hyunjung.day15.post.model.Post
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class PostDataSourceImpl : PostDataSource {
    override suspend fun getPost(id: Int): Post {
        require(id > 0) { "게시물 ID는 양수여야 합니다." }
        val url = "${Constants.BASE_URL}/posts/$id"
        return NetworkUtils.executeRequest(url) { response ->
            try {
                JsonParser.parseJson(response)
            } catch (e: Exception) {
                throw IllegalArgumentException("Error fetching posts: ${e.message}")
            }
        }
    }

    override suspend fun getPosts(): List<Post> {
        val url = "${Constants.BASE_URL}/posts"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}
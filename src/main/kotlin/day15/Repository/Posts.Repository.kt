package org.example.day15.Repository

import org.example.day15.Interface.PostDataSource
import org.example.day15.Interface.PostRepositoryImpl
import org.example.day15.Model.Post
import org.example.day15.Utils.parseJson


open class PostDataSourceImpl(private val jsonFilePath: String) : PostDataSource, PostRepositoryImpl {
    override var posts: List<Post>
        get() = parseJson(jsonFilePath)
        set(value) {}

    override suspend fun getPost(id: Int): List<Post> {
        if (posts.isEmpty()) emptyList<String?>()

        return posts.filter { post -> post.id == id }
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        if (posts.isEmpty()) emptyList<String?>()
        if (limit != null) {
            return if (page > 0) posts.filter { user -> user.id == page }.slice(0..<limit) else posts
        }
        return posts
    }
}


const val postDataSource = "./src/main/kotlin/day15/RawData/posts.json"

class PostRepository : PostDataSourceImpl(postDataSource) {}

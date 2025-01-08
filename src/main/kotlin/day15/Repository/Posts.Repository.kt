package org.example.day15.Repository

import org.example.day15.Interface.PostDataSource
import org.example.day15.Interface.PostRepositoryImpl
import org.example.day15.Model.Post
import org.example.day15.Model.User
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class PostDataSourceImpl(private val jsonDataSource: String) : PostDataSource, PostRepositoryImpl {
    private var _posts: List<Post> = parseJson(jsonDataSource)

    override val posts: List<Post?>
        get() = _posts

    override suspend fun getPost(id: Int): Post? {
        return posts.filter { post -> post?.id == id }[0]
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post?> {
        if (limit == null) return emptyList()
        return if (page > 0) posts.filter { user -> user?.id == page }.slice(0..<limit) else emptyList()
    }
}


const val postDataSource = "./src/main/kotlin/day15/RawData/posts.json"

class PostRepository : PostDataSourceImpl(readJson(postDataSource)) {}

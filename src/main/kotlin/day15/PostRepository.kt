package day15

import day15.models.Post

interface PostRepository {
    suspend fun findById(id: Int): Post?
    suspend fun paginated(pageIndex: Int = 1, pageSize: Int? = null): List<Post>
}
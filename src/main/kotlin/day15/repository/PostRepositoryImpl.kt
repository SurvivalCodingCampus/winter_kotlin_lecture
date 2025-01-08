package day15.repository

import day15.data_source.PostDataSource
import day15.model.Post

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.getPost(id)
    }

    suspend fun getPosts(): List<Post> {
        return dataSource.getPosts()
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        require(page > 0) { "페이지 번호는 1 이상이어야 합니다." }
        require(limit == null || limit > 0) { "한계값은 양수여야 합니다." }

        // page와 limit 값이 유효하지 않으면 기본값 1, 10으로 설정
        val correctedPage = if (page < 1) 1 else page
        val correctedLimit = limit?.takeIf { it > 0 } ?: 10

        val posts = dataSource.getPosts()
        if (posts.isEmpty()) return emptyList()

        val totalPosts = posts.size
        val startIndex = (correctedPage - 1) * correctedLimit
        val endIndex = startIndex + correctedLimit

        if (startIndex >= totalPosts) {
            return emptyList() // 범위를 넘는 페이지 번호는 빈 리스트 반환
        }

        // 페이지만큼 슬라이싱
        return posts.subList(startIndex, endIndex.coerceAtMost(posts.size))
    }
}

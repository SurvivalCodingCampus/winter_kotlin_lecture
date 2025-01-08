import org.example.day15.Model.Comment

interface MockCommentDataSource {
    suspend fun getComments(postId: Int): List<Comment>
}

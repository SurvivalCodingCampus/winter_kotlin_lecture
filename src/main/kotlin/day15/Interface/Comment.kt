import org.example.day15.Model.Comment

interface MockCommentDatasourceImpl {
    suspend fun getComments(postId: Int): List<Comment>
}

interface CommentRepositoryImpl {
    suspend fun getComments(postId: Int): List<Comment>
}

interface CommentDataSource {
    var comments: List<Comment>
}

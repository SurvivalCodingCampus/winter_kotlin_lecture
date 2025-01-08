import org.example.day15.Model.Comment
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson

interface MockCommentDatasourceImpl {
    suspend fun getComments(postId: Int): List<Comment>
}

interface CommentRepositoryImpl {
    suspend fun getComments(postId: Int): List<Comment>
}

const val commentDataSource = "./src/main/kotlin/day15/RawData/comments.json"

interface CommentDataSource {
    var comments: List<Comment>
}


import kotlinx.serialization.Serializable


@Serializable
data class DownloadInfo(
    val startTime: String,
    val endTime: String,
    val elapsedTime: String,
    val fileSize: String
)



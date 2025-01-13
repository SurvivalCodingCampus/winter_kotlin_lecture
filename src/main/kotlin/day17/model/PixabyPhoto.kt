package day17


data class PixabayModel(
    val total: Int,
    val totalHits: Int,
    val images: List<PixabayPhoto>
)

data class Image(
    val id: Int,
    val pageUrl: String,
    val type: String,
    val tags: List<String>,
    val previewUrl: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatUrl: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageUrl: String,
    val fullHdUrl: String,
    val imageUrl: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user: UserInfo
)

data class UserInfo(
    val id: Int,
    val name: String,
    val imageUrl: String
)

sealed class PhotoError {
    object NetworkError : PhotoError()
    object EmptyQuery : PhotoError()

    sealed class ServerError : PhotoError() {
        data class BadRequest(val details: String) : ServerError()
        data class InternalServerError(val details: String) : ServerError()
        data class UnknownError(val details: String) : ServerError()
        data class ApiKeyError(val details: String) : ServerError()
        data class IOException(val details: String) : ServerError()
    }

    // 공통 메시지 메서드
    fun toMessage(): String {
        return when (this) {
            is NetworkError -> "네트워크 오류가 발생했습니다."
            is EmptyQuery -> "쿼리가 비어 있습니다."
            is ServerError.BadRequest -> "잘못된 요청: $details"
            is ServerError.InternalServerError -> "서버 내부 오류: $details"
            is ServerError.UnknownError -> "알 수 없는 오류: $details"
            is ServerError.ApiKeyError -> "API 키 오류: $details"
            is ServerError.IOException -> "IOException 오류: $details"
            else -> {
                "알수없는 오류"
            }

        }
    }
}


enum class ServerErrorMessage {
    NETWORK_ERROR,
}


data class PixabayPhoto(
    val tags: List<String>,
    val imageUrl: String
)


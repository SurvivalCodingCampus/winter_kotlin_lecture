import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PixabayResponse(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<ImageHit>? = null,
)

@Serializable
data class ImageHit(
    val id: Int? = null,
    @SerialName("pageURL")
    val pageUrl: String? = null,
    val type: String? = null,
    val tags: String? = null,
    @SerialName("previewURL")
    val previewUrl: String? = null,
    val previewWidth: Int? = null,
    val previewHeight: Int? = null,
    @SerialName("webformatURL")
    val webformatUrl: String? = null,
    val webformatWidth: Int? = null,
    val webformatHeight: Int? = null,
    @SerialName("largeImageURL")
    val largeImageUrl: String? = null,
    @SerialName("fullHDURL")
    val fullHdUrl: String? = null,
    @SerialName("imageURL")
    val imageUrl: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Int? = null,
    val views: Int? = null,
    val downloads: Int? = null,
    val likes: Int? = null,
    val comments: Int? = null,
    @SerialName("user_id")
    val userId: Int? = null,
    val user: String? = null,
    @SerialName("userImageURL")
    val userImageUrl: String? = null
)
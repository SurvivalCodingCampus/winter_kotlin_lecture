package day17.dto

import day17.model.MediaItem
import day17.model.MediaType
import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class MediaDto(
    @Serializable(FallbackSerializer::class) val id: Int,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    @SerialName("created_at") val createdAt: String? = null
)

object FallbackSerializer : KSerializer<Int> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MediaDto", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Int {
        check(decoder is JsonDecoder)
        return decoder.decodeJsonElement().jsonPrimitive.content.toInt()
    }

    override fun serialize(encoder: Encoder, value: Int) {}

}

fun MediaDto.toMediaItem(): MediaItem {
    return when (val type = MediaType.of(type)) {
        MediaType.ARTICLE -> MediaItem(
            id = id,
            type = type,
            createdAt = createdAt?.let { LocalDate.parse(it) } ?: LocalDate.fromEpochDays(0),
            summary = title ?: "n/a",
            resource = content ?: ""
        )

        MediaType.IMAGE, MediaType.VIDEO, MediaType.UNKNOWN ->
            MediaItem(
                id = id,
                type = type,
                createdAt = createdAt?.let { LocalDate.parse(it) } ?: LocalDate.fromEpochDays(0),
                summary = caption ?: "n/a",
                resource = url ?: "",
            )

    }
}
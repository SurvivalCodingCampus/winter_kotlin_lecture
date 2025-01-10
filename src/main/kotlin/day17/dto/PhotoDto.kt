package day17.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
* JSON 응답 구조와 정확히 매핑 되는 PhotoDto 클래스 작성
* */
@Serializable
data class PhotoDto(
    val id: Int? = null,
    val type: String? = null,
    val title: String? = null,
    val url: String? = null,
    val caption: String? = null,
    val content: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)

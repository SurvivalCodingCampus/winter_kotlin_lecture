package day13.exercise

import kotlinx.serialization.Serializable


/*
* 영화 정보를 담는 데이터 클래스.
*
* */
@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int,
)




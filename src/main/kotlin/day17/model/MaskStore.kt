package day17.model

data class Pharmacy(
    val addr: String,
    val code: String,
    val createdAt: String,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String,
    val stockAt: String,
    val type: String
)
import org.example.day15.Utils.format

val mockData: String = """
    {
        "id": 939243,
        "title": "수퍼 소닉 3",
        "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
        "release_date": "2024-12-19"
    }
""".trimIndent()


class MockMovieDataSourceImpl : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return listOf(format.decodeFromString(mockData))
    }
}


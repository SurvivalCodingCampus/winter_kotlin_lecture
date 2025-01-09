package org.example.day16.data_source.movie

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day16.model.movie.MovieResponse

class MockMovieDataSourceImpl(jsonString: String? = null) : MovieDataSource {

    override suspend fun getMovieResponse(page: Int?, language: String?): MovieResponse = withContext(Dispatchers.IO) {
        try {
            defaultJson.decodeFromString<MovieResponse>(json)
        } catch (e: Exception) {
            throw e
        }
    }

    val json = jsonString ?: """
{
  "dates": {
    "maximum": "2025-02-05",
    "minimum": "2025-01-15"
  },
  "page": 1,
  "results": [
    {
      "adult": false,
      "backdrop_path": "/zOpe0eHsq0A2NvNyBbtT6sj53qV.jpg",
      "genre_ids": [28, 878, 35, 10751],
      "id": 939243,
      "original_language": "en",
      "original_title": "Sonic the Hedgehog 3",
      "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉. 연구 시설에 50년간 잠들어 있던 사상 최강의 비밀 병기 \"섀도우\"가 탈주하자, 세계 수호 통합 부대(약칭 세.수.통)에 의해 극비 소집된다. 소중한 것을 잃은 분노와 복수심에 불타는 섀도우는 소닉의 초고속 스피드와 너클즈의 최강 펀치를 단 단숨에 제압해버린다. 세상을 지배하려는 닥터 로보트닉과 그의 할아버지 제럴드 박사는 섀도우의 엄청난 힘 카오스 에너지를 이용해 인류를 정복하려고 하는데…",
      "popularity": 4186.749,
      "poster_path": "/5ZoI48Puf5i5FwI6HOpunDuJOw0.jpg",
      "release_date": "2024-12-19",
      "title": "수퍼 소닉 3",
      "video": false,
      "vote_average": 7.7,
      "vote_count": 384
    }
  ]
}
    """.trimIndent()
}
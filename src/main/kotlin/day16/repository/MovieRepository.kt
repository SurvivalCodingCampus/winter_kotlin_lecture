package day16.repository

import day16.model.Movie
/*
연습문제 1. Movie 정보 네트워크 통신 파싱 기능
<요구사항>
1. 실제 TMDB API를 호출하는 MovieDataSourceImpl 구현
2. 테스트용 MockMovieDataSourceImpl 구현
3. MovieRepositoryImpl 구현

<테스트 데이터>
{
    "id": 939243,
    "title": "수퍼 소닉 3",
    "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
    "release_date": "2024-12-19"
}

https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-core/kotlinx.serialization/-serial-name/

API 엔드포인트 : https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day16/
│               └── data_source/
│                   └── MovieDataSource
│                   └── MockMovieDatasource
│                   └── MovieDatasourceImpl
│               └── model/
│                   └── Movie
│               └── repository/
│                   └── MovieRepository
│                   └── MovieRepositoryImpl
*/
interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}
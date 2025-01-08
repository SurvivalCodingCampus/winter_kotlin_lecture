package day16.exercise.datasource.mock

import day15.common.ResponseResult
import day15.common.safeCall
import day16.exercise.model.Movie
import day16.util.TestJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json


// Test용 DataSourceImpl
class MockMovieDataSourceImpl : MockMovieDataSource {
    override suspend fun getMovieData(): ResponseResult<Movie> = withContext(Dispatchers.IO) {
        safeCall {
            Json.decodeFromString(TestJson.MOVIE_JSON)
        }
    }

}
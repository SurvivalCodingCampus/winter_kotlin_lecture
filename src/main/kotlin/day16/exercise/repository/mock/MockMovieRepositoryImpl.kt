package day16.exercise.repository.mock

import day15.common.ResponseResult
import day16.exercise.datasource.mock.MockMovieDataSource
import day16.exercise.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockMovieRepositoryImpl(
    private val mockMovieDataSource: MockMovieDataSource
) : MockMovieRepository {
    override suspend fun getMovieData(): Movie? = withContext(Dispatchers.IO) {
        when (val result = mockMovieDataSource.getMovieData()) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                println("Json 변환 실패 : ${result.exception.message}")
                null
            }
        }
    }
}
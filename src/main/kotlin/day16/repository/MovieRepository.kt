interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}

package org.hyunjung.day16.movie

import kotlinx.coroutines.runBlocking
import org.hyunjung.day16.movie.datasource.MovieDataSourceImpl
import org.hyunjung.day16.movie.repository.MovieRepositoryImpl

fun main() = runBlocking {
    val movieRepository = MovieRepositoryImpl(MovieDataSourceImpl())

    try {
        val movies = movieRepository.getMovieInfoList()
        println("Upcoming Movies:")
        movies.forEach { println(it) }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
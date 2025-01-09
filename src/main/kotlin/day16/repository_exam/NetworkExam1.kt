package org.example.day16.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day16.repository_exam.data_source.movie.MovieDataSourceImpl
import org.example.day16.repository_exam.repository.movie.MovieRepositoryImpl

fun main() = runBlocking {
    val movieRepository = MovieRepositoryImpl(MovieDataSourceImpl())

    println(movieRepository.getMovieInfoList())
}
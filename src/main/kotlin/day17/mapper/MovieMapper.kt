package org.example.day17.mapper

import org.example.day17.dto.MovieDto
import org.example.day17.model.movie.Movie
import java.time.LocalDate

fun MovieDto.toMovie() = Movie(
    id = id ?: -1,
    title = title ?: "",
    overview = overview ?: "",
    releaseDate = LocalDate.parse(release_date)
)
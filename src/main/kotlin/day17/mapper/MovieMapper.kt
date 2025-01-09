package day17.mapper

import day17.dto.MovieDto
import day17.model.Movie
import java.time.LocalDate

fun MovieDto.toMovie() = Movie(
    id = id ?: -1,
    title = title ?: "",
    overview = overview ?: "",
    releaseDate = LocalDate.parse(release_date)
)